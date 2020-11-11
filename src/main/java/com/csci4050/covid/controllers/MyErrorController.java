package com.csci4050.covid.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        return "<h1><Marquee>Something went wrong!</Marquee></h1>";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
