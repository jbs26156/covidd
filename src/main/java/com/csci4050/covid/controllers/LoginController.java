package com.csci4050.covid.controllers;


import com.csci4050.covid.entities.AccountEntity;
import com.csci4050.covid.repository.AccountRepository;
import com.csci4050.covid.utils.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class LoginController extends ControllerParent {
    @Autowired
    private final AccountRepository accountRepo;

    public LoginController(AccountRepository accountRepo) {
        super( "login", "index", "login" );
        this.accountRepo = accountRepo;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    private String showLoginPage(ModelMap model) {
        model.addAttribute( getLandingPage(), new AccountEntity() );
        return getLandingPage();
    }

    //TODO add message for invalid entry when logging in
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private Object submitLoginIn(@ModelAttribute("login") AccountEntity accountForm, Model model, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
        AccountEntity accountInstance = accountRepo.findByEmail( accountForm.getEmail().toLowerCase() );
        boolean match = !(accountInstance == null || !(accountInstance.getPassword().matches( accountForm.getPassword() )));
        if (!match) {
            String errors = "Email and Password do not match";
            request.setAttribute( "responseString", errors );
            return getLandingPage();
        }
        if (match) {
            CurrentUser user = new CurrentUser( accountForm.getEmail() );
            setCurrentUser( user );
            return getDestinationPage();
        }

        return getLandingPage();
    }

    private void setCurrentUser(CurrentUser user) {
        CurrentUser.firstName = user.getFirstName();
        CurrentUser.id = user.getId();
        CurrentUser.email = user.getEmail();
        CurrentUser.password = user.getPassword();
        CurrentUser.userName = user.getUserName();
        CurrentUser.lastName = user.getLastName();
        CurrentUser.phoneNumber = user.getPhoneNumber();
        CurrentUser.isEmailAlert = user.getIsEmailAlert();
        CurrentUser.isEmailAlert = user.getIsPhoneAlert();
    }
}
