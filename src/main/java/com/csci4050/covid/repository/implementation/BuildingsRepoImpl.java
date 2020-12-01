package com.csci4050.covid.repository.implementation;

import com.csci4050.covid.entities.BuildingsEntity;
import com.csci4050.covid.repository.Repos.BuildingsRepository;
import com.csci4050.covid.utils.H2JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class BuildingsRepoImpl implements BuildingsRepository {


    //Implemented methods

    @Override
    public String[] name(String name) {
        String[] list = new String[265];
        String querey = "SELECT * FROM BUILDINGS";
        H2JDBCUtils utils = new H2JDBCUtils();
        try (Connection connection = H2JDBCUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement( querey )) {
            ResultSet rs = preparedStatement.executeQuery();
            int index = 0;
            while (rs.next()) {
                String x = rs.getString( "NAME" );
                list[index] = x;
                index++;
            }
            return list;
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException( e );
        }
        return list;
    }
    //Unimplemented methods

    @Override
    public <S extends BuildingsEntity> S save(S s) {
        return null;
    }

    @Override
    public <S extends BuildingsEntity> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<BuildingsEntity> findById(Long Id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<BuildingsEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<BuildingsEntity> findAllById(Iterable<Long> iterable) {
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
    public void delete(BuildingsEntity buildingsEntity) {

    }

    @Override
    public void deleteAll(Iterable<? extends BuildingsEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
