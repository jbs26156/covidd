package com.csci4050.covid.repository.Repos;

import com.csci4050.covid.entities.ContactTraceEntity;
import org.springframework.data.repository.CrudRepository;


public interface ContactTraceRepo extends CrudRepository<ContactTraceEntity, Long> {
    ContactTraceEntity findByBuilding(String building);
    void sendOut(String email, String building);
}
