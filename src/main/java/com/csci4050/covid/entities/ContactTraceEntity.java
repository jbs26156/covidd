package com.csci4050.covid.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "ContactTraceTable")
public class ContactTraceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String email;
    private String building1;
    private String building2;
    private String building3;
    private String building4;
    private String building5;
    private String building6;
    private String building7;
    private String building8;
    private String building9;
    private String building10;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBuilding1() {
        return building1;
    }

    public void setBuilding1(String building1) {
        this.building1 = building1;
    }

    public String getBuilding2() {
        return building2;
    }

    public void setBuilding2(String building2) {
        this.building2 = building2;
    }

    public String getBuilding3() {
        return building3;
    }

    public void setBuilding3(String building3) {
        this.building3 = building3;
    }

    public String getBuilding4() {
        return building4;
    }

    public void setBuilding4(String building4) {
        this.building4 = building4;
    }

    public String getBuilding5() {
        return building5;
    }

    public void setBuilding5(String building5) {
        this.building5 = building5;
    }

    public String getBuilding6() {
        return building6;
    }

    public void setBuilding6(String building6) {
        this.building6 = building6;
    }

    public String getBuilding7() {
        return building7;
    }

    public void setBuilding7(String building7) {
        this.building7 = building7;
    }

    public String getBuilding8() {
        return building8;
    }

    public void setBuilding8(String building8) {
        this.building8 = building8;
    }

    public String getBuilding9() {
        return building9;
    }

    public void setBuilding9(String building9) {
        this.building9 = building9;
    }

    public String getBuilding10() {
        return building10;
    }

    public void setBuilding10(String building10) {
        this.building10 = building10;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
