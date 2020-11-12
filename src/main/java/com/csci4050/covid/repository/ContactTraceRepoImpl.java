package com.csci4050.covid.repository;

import com.csci4050.covid.entities.ContactTraceEntity;

import java.util.Optional;

public class ContactTraceRepoImpl implements ContactTraceRepo{
    @Override
    public ContactTraceEntity findByEmail(String email) {
        return null;
    }

    @Override
    public ContactTraceEntity findByBuilding(String building) {
        return null;
    }

    @Override
    public ContactTraceEntity findByAllBuilding(String building) {
        return null;
    }

    @Override
    public <S extends ContactTraceEntity> S save(S s) {
        return null;
    }

    @Override
    public <S extends ContactTraceEntity> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<ContactTraceEntity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<ContactTraceEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<ContactTraceEntity> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(ContactTraceEntity contactTraceEntity) {

    }

    @Override
    public void deleteAll(Iterable<? extends ContactTraceEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
