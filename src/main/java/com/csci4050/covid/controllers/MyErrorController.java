package com.csci4050.covid.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyErrorController extends ControllerParent implements ErrorController {
    private String errorMessage;

    public MyErrorController() {
        super( "/error", null,null );
        errorMessage = "<h1><Marquee>Something went wrong!</Marquee></h1>";
    }

    @RequestMapping("/error")
    private String handleError() {
        return errorMessage;
    }

    @Override
    public String getErrorPath() {
        return getLandingPage();
    }
}
