package com.csci4050.covid.controllers;

import com.csci4050.covid.utils.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {

    public LogoutController() {

    }

    //TODO populate page with correct page
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String showLoggedOutPage() {
        logoutCurUser();
        return "logout";
    }

    public void logoutCurUser() {
        CurrentUser.userName = null;
        CurrentUser.id = null;
        CurrentUser.firstName = null;
        CurrentUser.lastName = null;
        CurrentUser.password = null;
        CurrentUser.email = null;
        CurrentUser.phoneNumber = null;
        CurrentUser.isEmailAlert = null;
        CurrentUser.isPhoneAlert = null;
    }
}
