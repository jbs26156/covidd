package com.csci4050.covid.controllers;

import com.csci4050.covid.entities.AccountEntity;
import com.csci4050.covid.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class RegistrationController {

    @Autowired
    private AccountRepository accountRepo;

    public RegistrationController(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegPage(Model model) {
        model.addAttribute( "accountForm", new AccountEntity() );
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public Object registerAccount(@ModelAttribute("accountForm") AccountEntity accountForm, BindingResult bindingResult,
                                  Model model, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( null );
        }
        AccountEntity emailChecker = accountRepo.findByEmail( accountForm.getEmail() );
        AccountEntity userNameChecker = accountRepo.findByUserName( accountForm.getUserName() );

        accountForm.setFirstName( accountForm.getFirstName() );
        accountForm.setEmail( accountForm.getEmail().toLowerCase() );
        accountForm.setPassword( accountForm.getPassword() );
        accountForm.setUserName( accountForm.getUserName() );
        accountForm.setLastName( accountForm.getLastName() );
        accountForm.setPhoneNumber( accountForm.getPhoneNumber() );
        accountForm.setIsEmailAlert( accountForm.getIsEmailAlert() );
        accountForm.setIsPhoneAlert( accountForm.getIsPhoneAlert() );

        accountRepo.save( accountForm );

        return "registration";

    }

}
