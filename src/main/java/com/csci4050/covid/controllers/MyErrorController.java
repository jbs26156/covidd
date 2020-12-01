package com.csci4050.covid.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyErrorController implements ErrorController {
    private final String slashError = "/error";
    private final String errorMessage = "<h1><Marquee>Something went wrong!</Marquee></h1>";
    @RequestMapping(slashError)
    private String handleError() {
        return errorMessage;
    }

    @Override
    public String getErrorPath() {
        return slashError;
    }
}
