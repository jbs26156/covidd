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

    @Autowired
    private AccountRepository accountRepo;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
        model.addAttribute( "login", new AccountEntity() );
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object submitLoginIn(@ModelAttribute("login") AccountEntity accountForm, Model model) {

        AccountEntity accountInstance = accountRepo.findByEmail( accountForm.getEmail().toLowerCase() );
        if (accountInstance == null || !(accountInstance.getPassword().matches( accountForm.getPassword() ))) {
            System.out.println( "Email / Password does not exist" );
            System.out.println( accountInstance );
            return "login";
        }
        if (!(accountInstance == null || !(accountInstance.getPassword().matches( accountForm.getPassword() )))) {
            //Build currentuser object using repo
            CurrentUser user = new CurrentUser(accountForm.getEmail());
            CurrentUser.id = user.getId();
            CurrentUser.firstName = user.getFirstName();
            CurrentUser.email = user.getEmail();
            CurrentUser.password = user.getPassword();
            CurrentUser.userName = user.getUserName();
            CurrentUser.lastName = user.getLastName();
            CurrentUser.phoneNumber = user.getPhoneNumber();
            CurrentUser.isEmailAlert = user.getIsEmailAlert();
            CurrentUser.isEmailAlert = user.getIsPhoneAlert();
            return "index";
        }
        return "login";
    }
}
