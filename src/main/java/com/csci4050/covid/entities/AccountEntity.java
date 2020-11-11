package com.csci4050.covid.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "user")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private String firstName;

    private String password;

    private String email;

    private String lastName;

    private String phoneNumber;

    private String isPhoneAlert;

    private String isEmailAlert;



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

}
