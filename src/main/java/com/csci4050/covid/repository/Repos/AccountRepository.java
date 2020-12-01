package com.csci4050.covid.repository.Repos;

import com.csci4050.covid.entities.AccountEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {
    Optional<AccountEntity> findById(Long Id);

    AccountEntity findByUserName(String userName);

    AccountEntity findByEmail(String email);

    AccountEntity findByPhoneNumber(String phoneNumber);

}
