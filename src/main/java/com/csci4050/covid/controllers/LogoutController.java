package com.csci4050.covid.controllers;

import com.csci4050.covid.utils.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController extends ControllerParent {

    public LogoutController() {
        super( "logout", null ,null);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    private String showLoggedOutPage() {
        logoutCurUser();
        return getLandingPage();
    }

    private void logoutCurUser() {
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
