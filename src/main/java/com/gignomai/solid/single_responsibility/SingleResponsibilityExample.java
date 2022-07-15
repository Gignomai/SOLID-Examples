package com.gignomai.solid.single_responsibility;

public class SingleResponsibilityExample {

    // This method is an example of a multiple responsibility method, just imagine that instead of printing it really
    // does the business logic.
    public static void multipleResponsibilitiesAccountGeneration(String userData) {
        // Transforming/validating incoming data
        System.out.println(userData.toUpperCase());
        // Save data to DB
        System.out.println("Saving data to DB: " + userData);
        // Notifying an external service
        System.out.println("Calling invoice service");
    }

    // This method is an example of a single responsibility method, business logic has been move to individual methods
    // and the purpose of this method is just managing calls to the other method/classes/services.
    public static void singleResponsibilitiesAccountGeneration(String userData) {
        transformData(userData);
        saveDataToRepository(userData);
        callInvoiceService();
    }

    private static void callInvoiceService() {
        // Notifying an external service
        System.out.println("Calling invoice service");
    }

    private static void saveDataToRepository(String userData) {
        // Save data to DB
        System.out.println("Saving data to DB: " + userData);
    }

    private static void transformData(String userData) {
        // Transforming/validating incoming data
        System.out.println(userData.toUpperCase());
    }

    public static void main (String[] args) {
        multipleResponsibilitiesAccountGeneration("Name of the new user");

        singleResponsibilitiesAccountGeneration("Name of the new user");
    }
}
