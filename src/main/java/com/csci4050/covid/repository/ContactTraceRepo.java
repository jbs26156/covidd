package com.csci4050.covid.repository;

import com.csci4050.covid.entities.AccountEntity;
import com.csci4050.covid.entities.ContactTraceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface ContactTraceRepo extends CrudRepository<ContactTraceEntity, Long> {
    //TODO facade design pattern

    ContactTraceEntity findByBuilding(String building);
}
