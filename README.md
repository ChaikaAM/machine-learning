# Example Predictive Service Application
This is a repository containing a code for a simple ML application described in my article at DZone - [Predictive Services Development with Java and Weka](https://dzone.com/content/3333458). **Please read it** :)

Application reads a source dataset containing real estate property prices in Seattle - [prices.arff](src/main/resources/prices.arff).  
It uses linear regression for classifier, and can predict price depending on area (sqft), bedrooms (bd), and distance to the center (mi).  
All ML logic is encapsulated in [PredictiveService.java](src/main/java/com/dzone/PredictiveService.java).  

You can run application using:
```shell
mvn compile exec:java -Dexec.mainClass="com.dzone.Main"
```

Result analysis could also be found in [article](https://dzone.com/content/3333458). 