package com.csci4050.covid.controllers;

import com.csci4050.covid.entities.AccountEntity;
import com.csci4050.covid.entities.ContactTraceEntity;
import com.csci4050.covid.repository.AccountRepository;
import com.csci4050.covid.repository.BuildingsRepoImpl;
import com.csci4050.covid.repository.BuildingsRepository;
import com.csci4050.covid.repository.ContactTraceRepo;
import com.csci4050.covid.utils.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class SettingsController {
    @Autowired
    ContactTraceRepo contactTraceRepo;

    BuildingsRepoImpl buildingsRepoImpl = new BuildingsRepoImpl();

    //TODO - implement design patterns
    public SettingsController(ContactTraceRepo contactTraceRepo) {
        this.contactTraceRepo = contactTraceRepo;
    }

    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String showRegPage(Model model) {
        model.addAttribute( "selectForm", new ContactTraceEntity() );
        return "settings";
    }

    @RequestMapping(value = "/settings", method = RequestMethod.POST)
    public Object addBuildingsToTable(@ModelAttribute("selectForm") ContactTraceEntity contactTraceForm, BindingResult bindingResult,
                                      Model model, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( null );
        }
        boolean flag = true;
        if (flag) {
            if (Global.isEmailAlert) {
                contactTraceForm.setEmail( Global.curEmail );
            } else {
                contactTraceForm.setEmail( "" );
            }
            contactTraceForm.setId( Global.id );
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
        return "registration";
    }

    @ModelAttribute("buildingsList")
    public Map<String, String> getBuildingsList() {
        Map<String, String> buildingsList = new HashMap<String, String>();
        for (int i = 0; i < buildingsRepoImpl.buildingsList().length - 1; i++) {
            buildingsList.put( buildingsRepoImpl.buildingsList()[i], buildingsRepoImpl.buildingsList()[i] );
        }
        return buildingsList;
    }
}