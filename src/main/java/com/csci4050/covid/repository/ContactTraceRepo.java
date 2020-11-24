package com.csci4050.covid.repository;

import com.csci4050.covid.entities.AccountEntity;
import com.csci4050.covid.entities.ContactTraceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface ContactTraceRepo extends CrudRepository<ContactTraceEntity, Long> {
    Optional<ContactTraceEntity> findById(Long Id);

    ContactTraceEntity findByEmail(String email);

    ContactTraceEntity findByBuilding(String building);

    ContactTraceEntity findByAllBuilding(String building);



}
