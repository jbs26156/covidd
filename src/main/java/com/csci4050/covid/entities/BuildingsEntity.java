package com.csci4050.covid.entities;

import jdk.jfr.Enabled;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "buildings")
public class BuildingsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String direction;
    private String name;
    private Long numPositives;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumPositives() {
        return numPositives;
    }

    public void setNumPositives(Long numPositives) {
        this.numPositives = numPositives;
    }
}
