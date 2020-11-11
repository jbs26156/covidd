package com.csci4050.covid.controllers;


import com.csci4050.covid.entities.AccountEntity;
import com.csci4050.covid.repository.AccountRepository;
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
        model.addAttribute("login", new AccountEntity());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object submitLoginIn(@ModelAttribute("login") AccountEntity accountForm, Model model) {

        AccountEntity accountInstance = accountRepo.findByEmail(accountForm.getEmail().toLowerCase());

        if (accountInstance == null || !(accountInstance.getPassword().matches(accountForm.getPassword()))) {
            System.out.println("Email / Password does not exist");
            System.out.println(accountInstance);
            return "login";
        }
        if (!(accountInstance == null || !(accountInstance.getPassword().matches(accountForm.getPassword())))) {
            System.out.println("The email exists");
            return "index";
        }
        return null;
    }
}
