package com.csci4050.covid.controllers;

import com.csci4050.covid.entities.AccountEntity;
import com.csci4050.covid.repository.AccountRepository;
import com.csci4050.covid.utils.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
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
        String errors = "";
        System.out.println( errors.isEmpty() );
        boolean eFlag = false, uFlag = false, pFlag = false, pAlert = false, eAlert = false;
        AccountEntity emailChecker = accountRepo.findByEmail( accountForm.getEmail() );
        AccountEntity userNameChecker = accountRepo.findByUserName( accountForm.getUserName() );
        AccountEntity phoneNumberChecker = accountRepo.findByPhoneNumber( accountForm.getPhoneNumber() );
        if (emailChecker != null) {
            System.out.println( "Someone already exist with that email" );
            model.addAttribute( "emailExist", "Email already exist" );
            eFlag = true;
        }
        if (userNameChecker != null) {
            System.out.println( "Someone already exist with that userName" );
            model.addAttribute( "userNameExist", "UserName already exist" );
            uFlag = true;
        }
        if (phoneNumberChecker != null) {
            System.out.println( "Someone already exist with that Phone Number" );
            model.addAttribute( "phoneNumberExist", "Phone Number Exist already exist" );
            pFlag = true;
        }
        String e = accountForm.getIsEmailAlert().toLowerCase();
        String p = accountForm.getIsPhoneAlert().toLowerCase();

        if (e.equals( "yes" ) || e.equals( "no" )) {
            eAlert = false;
        } else {
            eAlert = true;
        }
        if (p.equals( "yes" ) || p.equals( "no" )) {
            pAlert = false;
        } else {
            pAlert = true;
        }

        if (!eFlag && !uFlag && !pFlag && !pAlert && !eAlert) {
            accountForm.setFirstName( accountForm.getFirstName() );
            accountForm.setEmail( accountForm.getEmail().toLowerCase() );
            accountForm.setPassword( accountForm.getPassword() );
            accountForm.setUserName( accountForm.getUserName() );
            Global.id = accountForm.getId();
            Global.curEmail = accountForm.getEmail();
            if (accountForm.getIsEmailAlert().toLowerCase().equals( "yes" )) {
                Global.isEmailAlert = true;
            } else {
                Global.isEmailAlert = false;
            }
            accountForm.setLastName( accountForm.getLastName() );
            accountForm.setPhoneNumber( accountForm.getPhoneNumber() );
            accountForm.setIsEmailAlert( accountForm.getIsEmailAlert() );
            accountForm.setIsPhoneAlert( accountForm.getIsPhoneAlert() );
            accountRepo.save( accountForm );
            return "settings";
        }

        if (eFlag) {
            String emailError = "Email already Used!";
            errors += emailError;
        }

        if (uFlag) {
            String userError = "Username already Used!";
            errors += userError;
        }
        if (pFlag) {
            String phoneError = "Phone number already Used!";
            errors += phoneError;
        }
        if (eAlert) {
            String ee = "please enter yes or no!";
            errors += ee;
        }
        if (pAlert) {
            String pp = "please enter yes or no!";
            errors += pp;
        }
        request.setAttribute( "responseString", errors );
        return "registration";
    }
}
