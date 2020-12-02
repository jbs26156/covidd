package com.csci4050.covid.controllers;

import com.csci4050.covid.entities.AccountEntity;
import com.csci4050.covid.repository.AccountRepository;
import com.csci4050.covid.utils.CurrentUser;
import com.csci4050.covid.utils.StringUtils;
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
public class RegistrationController extends ControllerParent {
    @Autowired
    private AccountRepository accountRepo;

    public RegistrationController(AccountRepository accountRepo) {
        super( "registration", "index", "accountForm" );
        this.accountRepo = accountRepo;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    private String showRegPage(Model model) {
        model.addAttribute( getFormName(), new AccountEntity() );
        return "/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    private Object registerAccount(@ModelAttribute("accountForm") AccountEntity accountForm, BindingResult bindingResult,
                                   Model model, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( null );
        }
        boolean eFlag = false, uFlag = false, pFlag = false, pAlert = false, eAlert = false, passwordEmpty =false;
        AccountEntity emailChecker = accountRepo.findByEmail( accountForm.getEmail() );
        AccountEntity userNameChecker = accountRepo.findByUserName( accountForm.getUserName() );
        AccountEntity phoneNumberChecker = accountRepo.findByPhoneNumber( accountForm.getPhoneNumber() );
        if (emailChecker != null) {
            model.addAttribute( "emailExist", "Email already exist" );
            eFlag = true;
        }
        if (userNameChecker != null) {
            model.addAttribute( "userNameExist", "UserName already exist" );
            uFlag = true;
        }
        if (phoneNumberChecker != null) {
            model.addAttribute( "phoneNumberExist", "Phone Number Exist already exist" );
            pFlag = true;
        }
        if(accountForm.getPassword().equals( "" )){
            passwordEmpty=true;
        }
        String emailAlertFromForm = accountForm.getIsEmailAlert();
        String phoneAlertFromForm = accountForm.getIsPhoneAlert();

        if (!StringUtils.yesOrNo( emailAlertFromForm )) {
            eAlert = true;
        }
        if (!StringUtils.yesOrNo( phoneAlertFromForm )) {//DELETE
            pAlert = true;
        }
        if (!eFlag && !uFlag && !pFlag && !pAlert && !eAlert && !passwordEmpty) {//DELETE P PART
            accountForm.setFirstName( accountForm.getFirstName() );
            accountForm.setEmail( accountForm.getEmail().toLowerCase() );
            accountForm.setPassword( accountForm.getPassword() );
            accountForm.setUserName( accountForm.getUserName() );
            accountForm.setLastName( accountForm.getLastName() );
            accountForm.setPhoneNumber( accountForm.getPhoneNumber() );
            accountForm.setIsEmailAlert( accountForm.getIsEmailAlert() );
            accountForm.setIsPhoneAlert( accountForm.getIsPhoneAlert() );
            accountRepo.save( accountForm );
            CurrentUser.id = accountForm.getId();
            CurrentUser.firstName = accountForm.getFirstName();
            CurrentUser.email = accountForm.getEmail();
            CurrentUser.password = accountForm.getPassword();
            CurrentUser.userName = accountForm.getUserName();
            CurrentUser.lastName = accountForm.getLastName();
            CurrentUser.phoneNumber = accountForm.getPhoneNumber();
            CurrentUser.isEmailAlert = accountForm.getIsEmailAlert();
            CurrentUser.isEmailAlert = accountForm.getIsPhoneAlert();
            return getDestinationPage();
        }

        String errors = errorMessage( eFlag, uFlag, pFlag, eAlert, pAlert,passwordEmpty );
        request.setAttribute( "responseString", errors );
        return getLandingPage();
    }

    private String errorMessage(boolean eFlag, boolean uFlag, boolean pFlag, boolean eAlert, boolean pAlert,boolean passwordEmpty) {
        String errors = "";
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
        if(passwordEmpty){
            String pp = "password cannot be empty";
            errors+=pp;
        }
        return errors;
    }

}
