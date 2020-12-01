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

@Controller
public class LoginController {
    //Final lInstance Variables
    @Autowired
    private final AccountRepository accountRepo;
    private final String login = "login";
    private final String index = "index";
    private final String slashLogin = "/login";

    public LoginController(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;

    }

    @RequestMapping(value = slashLogin, method = RequestMethod.GET)
    private String showLoginPage(ModelMap model) {
        model.addAttribute( login, new AccountEntity() );
        return login;
    }

    //TODO add message for invalid entry when logging in
    @RequestMapping(value = slashLogin, method = RequestMethod.POST)
    private Object submitLoginIn(@ModelAttribute(login) AccountEntity accountForm, Model model) {
        AccountEntity accountInstance = accountRepo.findByEmail( accountForm.getEmail().toLowerCase() );
        boolean match = !(accountInstance == null || !(accountInstance.getPassword().matches( accountForm.getPassword() )));
        if (!match) {
            return login;
        }
        if (match) {
            CurrentUser user = new CurrentUser( accountForm.getEmail() );
            setCurrentUser( user );
            return index;
        }
        return login;
    }

    private void setCurrentUser(CurrentUser user) {
        CurrentUser.id = user.getId();
        CurrentUser.firstName = user.getFirstName();
        CurrentUser.email = user.getEmail();
        CurrentUser.password = user.getPassword();
        CurrentUser.userName = user.getUserName();
        CurrentUser.lastName = user.getLastName();
        CurrentUser.phoneNumber = user.getPhoneNumber();
        CurrentUser.isEmailAlert = user.getIsEmailAlert();
        CurrentUser.isEmailAlert = user.getIsPhoneAlert();
    }
}
