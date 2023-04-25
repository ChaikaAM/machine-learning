package com.dzone;

public class Main {

    public static void main(String[] args) throws Exception {
        PredictiveService predictiveService = new PredictiveService();

        predictiveService.predictPrice(2000, 4, 1.0);
        predictiveService.predictPrice(2000, 4, 2.0);
        predictiveService.predictPrice(2000, 4, 3.0);
        predictiveService.predictPrice(1000, 3, 5.0);
        predictiveService.predictPrice(1500, 2, 7.0);
        predictiveService.predictPrice(2000, 4, 10.0);
    }

}
