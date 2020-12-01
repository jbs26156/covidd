package com.csci4050.covid.controllers;

import com.csci4050.covid.entities.ContactTraceEntity;
import com.csci4050.covid.repository.BuildingsRepoImpl;
import com.csci4050.covid.repository.ContactTraceRepo;
import com.csci4050.covid.utils.CurrentUser;
import com.csci4050.covid.utils.H2JDBCUtils;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SettingsController extends ControllerParent {
    @Autowired
    private ContactTraceRepo contactTraceRepo;
    private final String slashSettings = "/settings";
    private final String slashIndex = "/index";

    public SettingsController(ContactTraceRepo contactTraceRepo) {
        super( "settings", "index", "selectForm" );
        this.contactTraceRepo = contactTraceRepo;
    }

    @RequestMapping(value = slashSettings, method = RequestMethod.GET)
    private String showSettingPage(Model model) {
        model.addAttribute( getFormName(), new ContactTraceEntity() );
        return getLandingPage();
    }

    @RequestMapping(value = slashIndex, method = RequestMethod.GET)
    private String showIndexPage(Model model) {
        return getDestinationPage();
    }


    @RequestMapping(value = slashSettings, method = RequestMethod.POST)
    private Object addBuildingsToTable(@ModelAttribute("selectForm") ContactTraceEntity selectForm, BindingResult bindingResult,
                                       Model model, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( null );
        }
        String query = "";
        H2JDBCUtils utils = new H2JDBCUtils();
        String yesOrNo = CurrentUser.isEmailAlert.toLowerCase();
        String idQuery = "SELECT COUNT(*) FROM CONTACT_TRACE_TABLE;";
        try (Connection c = utils.getConnection();
             PreparedStatement preparedStatement = c.prepareStatement( idQuery )) {
            ResultSet rs = preparedStatement.executeQuery();
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException( e );
        }
        if (yesOrNo.equals( "yes" )) {
            String selectStar = "SELECT * FROM CONTACT_TRACE_TABLE WHERE ID = " + CurrentUser.id;
            try (Connection c = utils.getConnection();
                 PreparedStatement preparedStatement = c.prepareStatement( selectStar )) {
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    long index = CurrentUser.id;
                    query = "UPDATE CONTACT_TRACE_TABLE SET building1 = \'" + selectForm.getBuilding1() + "\' , building2 = \'" + selectForm.getBuilding2() + "\', building3 = \'" + selectForm.getBuilding3() + "\' , building4 = \'" + selectForm.getBuilding4() + "\', building5 = \'" + selectForm.getBuilding5() + "\', building6 = \'" + selectForm.getBuilding6() + "\' , building7 = \'" + selectForm.getBuilding7() + "\', building8 = \'" + selectForm.getBuilding8() + "\' , building9 = \'" + selectForm.getBuilding9() + "\', building10 = \'" + selectForm.getBuilding10() + "\' WHERE ID=" + index;
                } else {
                    long index = CurrentUser.id;
                    query = "INSERT INTO CONTACT_TRACE_TABLE (id, building1, building2, building3, building4, building5, building6, building7, building8, building9, building10, email, username)" +
                            "VALUES (" + index + ", \'" + selectForm.getBuilding1() + "\', \'" + selectForm.getBuilding2() + "\', \'" + selectForm.getBuilding3() + "\', \'" + selectForm.getBuilding4() + "\', \'" + selectForm.getBuilding5() + "\', \'" + selectForm.getBuilding6() + "\', \'" + selectForm.getBuilding7() + "\', \'" + selectForm.getBuilding8() + "\', \'" + selectForm.getBuilding9() + "\', \'" + selectForm.getBuilding10() + "\', \'" + CurrentUser.email + "\', \'" + CurrentUser.userName + "\')";
                }
            } catch (SQLException e) {
                H2JDBCUtils.printSQLException( e );
            }

        } else {
            String selectStar = "SELECT * FROM CONTACT_TRACE_TABLE WHERE ID = " + CurrentUser.id;
            try (Connection c = utils.getConnection();
                 PreparedStatement preparedStatement = c.prepareStatement( selectStar )) {
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    long index = CurrentUser.id;
                    query = "UPDATE CONTACT_TRACE_TABLE SET building1 =\'" + selectForm.getBuilding1() + "\' , building2 = \'" + selectForm.getBuilding2() + "\', building3 = \'" + selectForm.getBuilding3() + "\' , building4 = \'" + selectForm.getBuilding4() + "\', building5 = \'" + selectForm.getBuilding5() + "\', building6 = \'" + selectForm.getBuilding6() + "\' , building7 = \'" + selectForm.getBuilding7() + "\', building8 = \'" + selectForm.getBuilding8() + "\' , building9 = \'" + selectForm.getBuilding9() + "\', building10 = \'" + selectForm.getBuilding10() + "\' WHERE ID=" + index;
                } else {
                    long index = CurrentUser.id;
                    query = "INSERT INTO CONTACT_TRACE_TABLE (id, building1, building2, building3, building4, building5, building6, building7, building8, building9, building10, email, username)" +
                            "VALUES (" + index + ", \'" + selectForm.getBuilding1() + "\', \'" + selectForm.getBuilding2() + "\', \'" + selectForm.getBuilding3() + "\', \'" + selectForm.getBuilding4() + "\', \'" + selectForm.getBuilding5() + "\', \'" + selectForm.getBuilding6() + "\', \'" + selectForm.getBuilding7() + "\', \'" + selectForm.getBuilding8() + "\', \'" + selectForm.getBuilding9() + "\', \'" + selectForm.getBuilding10() + "\', \'" + "\', \'" + CurrentUser.userName + "\')";
                }
            } catch (SQLException e) {
                H2JDBCUtils.printSQLException( e );
            }

        }
        try (Connection connection = utils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement( query )) {
            System.out.println( preparedStatement );
            int numRows = preparedStatement.executeUpdate();
            System.out.println( numRows );
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException( e );
        }
        return getDestinationPage();
    }


    @ModelAttribute("buildingsList")
    private Map<String, String> getBuildingsList() {
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
