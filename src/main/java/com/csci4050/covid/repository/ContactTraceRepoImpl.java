package com.csci4050.covid.repository;

import com.csci4050.covid.entities.ContactTraceEntity;
import com.csci4050.covid.utils.H2JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;


//Java Mail imports
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class ContactTraceRepoImpl implements ContactTraceRepo {

    @Override
    public ContactTraceEntity findByBuilding(String building) {
        if (!building.equals( "none" )) {
            String query = "SELECT * FROM CONTACT_TRACE_TABLE WHERE \'" + building + "\' IN (BUILDING1, BUILDING2, BUILDING3, BUILDING4, BUILDING5, BUILDING6, BUILDING7, BUILDING8, BUILDING9, BUILDING10)";
            ContactTraceEntity contactTraceEntityObject = new ContactTraceEntity();
            H2JDBCUtils utils = new H2JDBCUtils();
            try (Connection connection = H2JDBCUtils.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement( query )) {
                System.out.println( preparedStatement );
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    contactTraceEntityObject.setEmail( rs.getString( "email" ) );
                    contactTraceEntityObject.setBuilding1( rs.getString( "building1" ) );
                    contactTraceEntityObject.setBuilding2( rs.getString( "building2" ) );
                    contactTraceEntityObject.setBuilding3( rs.getString( "building3" ) );
                    contactTraceEntityObject.setBuilding4( rs.getString( "building4" ) );
                    contactTraceEntityObject.setBuilding5( rs.getString( "building5" ) );
                    contactTraceEntityObject.setBuilding6( rs.getString( "building6" ) );
                    contactTraceEntityObject.setBuilding7( rs.getString( "building7" ) );
                    contactTraceEntityObject.setBuilding8( rs.getString( "building8" ) );
                    contactTraceEntityObject.setBuilding9( rs.getString( "building9" ) );
                    contactTraceEntityObject.setBuilding10( rs.getString( "building10" ) );
                    sendOut( contactTraceEntityObject.getEmail(), building );
                }
                //Send emails
                //If email_column is not empty, send email.
                System.out.println( "Email should be : " + contactTraceEntityObject.getEmail() );
//                if (!contactTraceEntityObject.getEmail().equalsIgnoreCase( "" )) {
//                    String to = contactTraceEntityObject.getEmail();
//                    String from = "COVID.Alerts.FA2020@gmail.com";
//                    String host = "smtp.gmail.com";
//                    Properties properties = System.getProperties();
//                    properties.put( "mail.smtp.host", host );
//                    properties.put( "mail.smtp.port", "465" );
//                    properties.put( "mail.smtp.ssl.enable", "true" );
//                    properties.put( "mail.smtp.auth", "true" );
//                    String username = "COVID.Alerts.FA2020@gmail.com";
//                    String password = "teama2project";
//                    Session session = Session.getInstance( properties, new javax.mail.Authenticator() {
//                        protected PasswordAuthentication getPasswordAuthentication() {
//                            return new PasswordAuthentication( username, password );
//                        }
//                    } );
//
//                    MimeMessage message = new MimeMessage( session );
//                    try {
//                        InternetAddress fromIA = new InternetAddress( from );
//                        message.setFrom( from );
//                        InternetAddress toIA = new InternetAddress( to );
//                        message.addRecipient( Message.RecipientType.TO, toIA );
//                        message.setSubject( "CAUTION! COVID case near you detected." );
//                        message.setText( "Please be careful around " + building + ". There was a COVID-19 positive person reported to have been there recently." );
//                        Transport.send( message );
//                    } catch (MessagingException mEx) {
//                        mEx.printStackTrace();
//                    }
//
//                    return contactTraceEntityObject;
//                }
            } catch (SQLException e) {
                H2JDBCUtils.printSQLException( e );
            }
        }
        return null;
    }

    @Override
    public void sendOut(String email, String building) {
        if (!email.equalsIgnoreCase( "" )) {
            String to = email;
            String from = "COVID.Alerts.FA2020@gmail.com";
            String host = "smtp.gmail.com";
            Properties properties = System.getProperties();
            properties.put( "mail.smtp.host", host );
            properties.put( "mail.smtp.port", "465" );
            properties.put( "mail.smtp.ssl.enable", "true" );
            properties.put( "mail.smtp.auth", "true" );
            String username = "COVID.Alerts.FA2020@gmail.com";
            String password = "teama2project";
            Session session = Session.getInstance( properties, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication( username, password );
                }
            } );

            MimeMessage message = new MimeMessage( session );
            try {
                InternetAddress fromIA = new InternetAddress( from );
                message.setFrom( from );
                InternetAddress toIA = new InternetAddress( to );
                message.addRecipient( Message.RecipientType.TO, toIA );
                message.setSubject( "CAUTION! COVID case near you detected." );
                message.setText( "Please be careful around " + building + ". There was a COVID-19 positive person reported to have been there recently." );
                Transport.send( message );
            } catch (MessagingException mEx) {
                mEx.printStackTrace();
            }

        }
    }

    @Override
    public <S extends ContactTraceEntity> S save(S s) {
        return null;
    }

    @Override
    public <S extends ContactTraceEntity> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<ContactTraceEntity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<ContactTraceEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<ContactTraceEntity> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(ContactTraceEntity contactTraceEntity) {

    }

    @Override
    public void deleteAll(Iterable<? extends ContactTraceEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
