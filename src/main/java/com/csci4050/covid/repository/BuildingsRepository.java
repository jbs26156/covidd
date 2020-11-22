package com.csci4050.covid.repository;

import com.csci4050.covid.entities.AccountEntity;
import com.csci4050.covid.entities.BuildingsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BuildingsRepository extends CrudRepository<BuildingsEntity, Long> {
    Optional<BuildingsEntity> findById(Long Id);

    String[] buildingsList();
}
