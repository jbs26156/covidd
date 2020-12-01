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

/**
 * Controller that handles the contact tracing page.
 * Contains a get method and post method and a method to add
 * the building names to the page.
 */
@Controller
public class ContactTracingController {

    @Autowired
    ContactTraceRepo contactTraceRepo; // We use the repo to interact with the contact trace table in the DB

    /**
     * Constructor. This is never explicitly called in our code but it is used
     * by Spring Boot
     *
     * @param contactTraceRepo - sets the contact trace repo to this one passed in ¬
     */
    public ContactTracingController(ContactTraceRepo contactTraceRepo) {
        this.contactTraceRepo = contactTraceRepo;
    }

    /**
     * Method that links the model attribute from the contacttracing.jsp to a contact trace entity
     *
     * @param model - used for our model attribute
     * @return - the page, contacttracing
     */
    @RequestMapping(value = "/contacttracing", method = RequestMethod.GET)
    private String showContactTracePage(Model model) {
        //Creates a contact trace entity object and links it to the contactTraceForm
        model.addAttribute( "contactTracingForm", new ContactTraceEntity() );
        final String contacttracing = "contacttracing"; //The page address to return to
        return contacttracing;
    }

    /**
     * Post method to get the users input from the form and link it to the contact_trace_table in the DB.
     * The method also will Reference the ContactTraceRepoImpl class to use functions
     *
     * @param contactTraceForm - the forms from the contacttracing.jsp
     * @param bindingResult
     * @param model - to link to the model attribute
     * @param request
     * @return
     * @throws UnsupportedEncodingException - throws if present
     * @throws MessagingException - throws if present
     */
    @RequestMapping(value = "/contacttracing", method = RequestMethod.POST)
    private Object contactTrace(@ModelAttribute("contactTracingForm") ContactTraceEntity contactTraceForm, BindingResult bindingResult,
                               Model model, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( null );//if found do this
        }
        String bList[] = new String[10]; //This list is going to be used with the findByBuilding function
        ContactTraceRepoImpl contactTraceRepo = new ContactTraceRepoImpl();//
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
            if (!bList[i].equals( "" )|| bList[i] != null) {
                contactTraceRepo.findByBuilding( bList[i] );
            } else {
                continue;
            }
        }
        String index = "index";
        return index;
    }

    /**
     * Method is used to get the buildings and put them in a map
     * to aid the front end
     * @return
     */
    @ModelAttribute("buildingsList")
    private Map<String, String> getBuildingsList() {
        Map<String, String> buildingsList = new HashMap<>();
        BuildingsRepoImpl repo = new BuildingsRepoImpl();
        int len = repo.name( "" ).length;
        for (int i = 0; i < len - 1; i++) {
            String name = repo.name( "" )[i];
            buildingsList.put( name, name );
        }
        return buildingsList;
    }

}
