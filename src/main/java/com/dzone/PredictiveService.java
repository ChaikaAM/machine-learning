package com.dzone;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.LinearRegression;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

public class PredictiveService {

    private final Instances data;
    private final Classifier classifier;

    private final Instance instance;

    public PredictiveService() throws Exception {
        // Loading Albuquerque real estate prices
        ConverterUtils.DataSource source = new ConverterUtils.DataSource("prices.arff");
        data = source.getDataSet();
        // Setting the last attribute (price) to the class index
        data.setClassIndex(data.numAttributes() - 1);

        // Creating a linear regression based classifier
        classifier = new LinearRegression();

        // Let's learn classifier with data
        classifier.buildClassifier(data);

        // Creating an Instance for predictions
        instance = new DenseInstance(data.numAttributes());
        instance.setDataset(data);
    }

    /**
     * Predict price of the real estate property in Seattle
     * @param area sqft
     * @param bedrooms bd
     * @param milesAway mi
     */
    public void predictPrice(double area, int bedrooms, double milesAway) throws Exception {
        // Let's ask for a price for the property:
        instance.setValue(0, area);
        instance.setValue(1, bedrooms);
        instance.setValue(2, milesAway);

        // Price prediction action
        double predictedPrice = classifier.classifyInstance(instance);
        System.out.println("-- Predicting price for [area -" + area + " sqft, bedrooms - " + bedrooms + ", miles away - " + milesAway + " mi]");
        System.out.println("Predicted price: " + predictedPrice);

        // Calculation error rate
        Evaluation eval = new Evaluation(data);
        eval.evaluateModel(classifier, data);
        System.out.println("Calculation error rate: " + eval.errorRate());
    }
}


