package com.csci4050.covid.repository.Repos;

import com.csci4050.covid.entities.BuildingsEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BuildingsRepository extends CrudRepository<BuildingsEntity, Long> {
    Optional<BuildingsEntity> findById(Long Id);

    String[] name(String name);
}
