package com.csci4050.covid.controllers;

import com.csci4050.covid.utils.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {
    public LogoutController() {

    }
    //TODO populate page with correct page
    final String page = "f";
    @RequestMapping(value = page, method = RequestMethod.GET)
    public String showLoggedOutPage() {
        System.out.println( "Pre logout Current email: " + CurrentUser.email );
        logoutCurUser();
        System.out.println( "Post logout Current email: " + CurrentUser.email );
        return "index";
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
