package com.csci4050.covid.controllers;

import com.csci4050.covid.entities.ContactTraceEntity;
import com.csci4050.covid.repository.BuildingsRepoImpl;
import com.csci4050.covid.repository.ContactTraceRepo;
import com.csci4050.covid.repository.ContactTraceRepoImpl;
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
import java.util.HashMap;
import java.util.Map;

@Controller
public class ContactTracingController {

    @Autowired
    ContactTraceRepo contactTraceRepo;

    public ContactTracingController(ContactTraceRepo contactTraceRepo) {
        this.contactTraceRepo = contactTraceRepo;
    }


    @RequestMapping(value = "/contacttracing", method = RequestMethod.GET)
    public String showContactTracePage(Model model) {
        model.addAttribute( "contactTracingForm", new ContactTraceEntity() );
        return "contacttracing";
    }

    @RequestMapping(value = "/contacttracing", method = RequestMethod.POST)
    public Object contactTrace(@ModelAttribute("contactTracingForm") ContactTraceEntity contactTraceForm, BindingResult bindingResult,
                               Model model, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( null );
        }
        String bList[] = new String[10];
        ContactTraceRepoImpl contactTraceRepo = new ContactTraceRepoImpl();
        //Sorry that the mapping is one number off
        bList[0] = contactTraceForm.getBuilding1();
        bList[1] = contactTraceForm.getBuilding2();
        bList[2] = contactTraceForm.getBuilding3();
        bList[3] = contactTraceForm.getBuilding4();
        bList[4] = contactTraceForm.getBuilding5();
        bList[5] = contactTraceForm.getBuilding6();
        bList[6] = contactTraceForm.getBuilding7();
        bList[7] = contactTraceForm.getBuilding8();
        bList[8] = contactTraceForm.getBuilding9();
        bList[9] = contactTraceForm.getBuilding10();
        for (int i = 0; i < 10; i++) {
            if (!bList[i].equals( "" ) || bList[i] != null) {
                contactTraceRepo.findByBuilding( bList[i] );
            } else {
                continue;
            }
        }
        return "index";
    }

    @ModelAttribute("buildingsList")
    public Map<String, String> getBuildingsList() {
        Map<String, String> buildingsList = new HashMap<String, String>();
        BuildingsRepoImpl hey = new BuildingsRepoImpl();
        int len = hey.name( "" ).length;
        for (int i = 0; i < len - 1; i++) {
            String name = hey.name( "" )[i];
            buildingsList.put( name, name );
        }
        return buildingsList;
    }

}
