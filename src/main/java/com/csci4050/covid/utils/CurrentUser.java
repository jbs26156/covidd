package com.csci4050.covid.utils;

import com.csci4050.covid.entities.AccountEntity;
import com.csci4050.covid.repository.implementation.AccountRepositoryImp;

public class CurrentUser {

    public static Long id;

    public static String userName;

    public static String firstName;

    public static String password;

    public static String email;

    public static String lastName;

    public static String phoneNumber;

    public static String isPhoneAlert;

    public static String isEmailAlert;

    public CurrentUser(Long id, String userName, String firstName, String password, String email, String lastName, String phoneNumber, String isPhoneAlert, String isEmailAlert) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.password = password;
        this.email = email;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.isPhoneAlert = isPhoneAlert;
        this.isEmailAlert = isEmailAlert;
    }

    public CurrentUser() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIsPhoneAlert() {
        return isPhoneAlert;
    }

    public void setIsPhoneAlert(String isPhoneAlert) {
        this.isPhoneAlert = isPhoneAlert;
    }

    public String getIsEmailAlert() {
        return isEmailAlert;
    }

    public void setIsEmailAlert(String isEmailAlert) {
        this.isEmailAlert = isEmailAlert;
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isPhoneAlert='" + isPhoneAlert + '\'' +
                ", isEmailAlert='" + isEmailAlert + '\'' +
                '}';
    }

    public CurrentUser(String email) {
        CurrentUser currentUser = new CurrentUser();
        AccountRepositoryImp accountRepositoryImp = new AccountRepositoryImp();
        AccountEntity currentAccountEntity = accountRepositoryImp.findByEmail( email );
        currentUser.setEmail( currentAccountEntity.getEmail() );
        currentUser.setFirstName( currentAccountEntity.getFirstName() );
        currentUser.setLastName( currentAccountEntity.getLastName() );
        currentUser.setId( currentAccountEntity.getId() );
        currentUser.setPassword( currentAccountEntity.getPassword() );
        currentUser.setIsEmailAlert( currentAccountEntity.getIsEmailAlert() );
        currentUser.setIsPhoneAlert( currentAccountEntity.getIsPhoneAlert() );
        currentUser.setPhoneNumber( currentAccountEntity.getPhoneNumber() );
    }
}
