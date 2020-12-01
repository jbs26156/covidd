package com.csci4050.covid.controllers;

public class ControllerParent {
    public final String landingPage;
    public final String destinationPage;
    public final String formName;

    public ControllerParent(String landingPage, String destinationPage, String formName) {
        this.landingPage = landingPage;
        this.destinationPage = destinationPage;
        this.formName = formName;
    }

    public String getLandingPage() {
        return landingPage;
    }

    public String getDestinationPage() {
        return destinationPage;
    }

    public String getFormName() {
        return formName;
    }

}
