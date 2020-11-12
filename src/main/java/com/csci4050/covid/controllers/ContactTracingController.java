package com.csci4050.covid.controllers;

import com.csci4050.covid.entities.AccountEntity;
import com.csci4050.covid.entities.ContactTraceEntity;
import com.csci4050.covid.repository.AccountRepository;
import com.csci4050.covid.repository.ContactTraceRepo;
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
public class ContactTracingController {

    @Autowired
    ContactTraceRepo contactTraceRepo;
    public ContactTracingController( ContactTraceRepo contactTraceRepo) {
        this.contactTraceRepo = contactTraceRepo;

    }


    @RequestMapping(value = "/contacttracing", method = RequestMethod.GET)
    public String showContactTracePage(Model model) {
        model.addAttribute( "contactTracingForm", new ContactTraceEntity() );
        return "contacttracing";
    }

    @RequestMapping(value = "/contacttracing", method = RequestMethod.POST)
    public Object contactTrace(@ModelAttribute("contactTracingForm") ContactTraceEntity contactTraceForm, BindingResult bindingResult,
                               Model model, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException{

        if (bindingResult.hasErrors()) {
            return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( null );
        }
        //Code to send alert
        //Code to ensure there are no duplicate entries in the table

        contactTraceForm.setEmail( contactTraceForm.getEmail() );
        contactTraceForm.setBuilding1( contactTraceForm.getBuilding1() );
        contactTraceForm.setBuilding2( contactTraceForm.getBuilding2() );
        contactTraceForm.setBuilding3( contactTraceForm.getBuilding3() );
        contactTraceForm.setBuilding4( contactTraceForm.getBuilding4() );
        contactTraceForm.setBuilding5( contactTraceForm.getBuilding5() );
        contactTraceForm.setBuilding6( contactTraceForm.getBuilding6() );
        contactTraceForm.setBuilding7( contactTraceForm.getBuilding7() );
        contactTraceForm.setBuilding8( contactTraceForm.getBuilding8() );
        contactTraceForm.setBuilding9( contactTraceForm.getBuilding9() );
        contactTraceForm.setBuilding10( contactTraceForm.getBuilding10() );
        contactTraceRepo.save( contactTraceForm );
        return "index";
    }

}
