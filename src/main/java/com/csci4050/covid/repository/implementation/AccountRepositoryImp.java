package com.csci4050.covid.repository.implementation;

import com.csci4050.covid.entities.AccountEntity;
import com.csci4050.covid.repository.Repos.AccountRepository;
import com.csci4050.covid.utils.H2JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class AccountRepositoryImp implements AccountRepository {
    //Implemented methods

    @Override
    public AccountEntity findByUserName(String userName) {
        //Check database for existing
        String querey = "SELECT * FROM USER WHERE USER_NAME = \' " + userName + "\'";
        AccountEntity account = new AccountEntity();
        H2JDBCUtils utils = new H2JDBCUtils();
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement( querey )) {
            preparedStatement.setInt( 1, 1 );
            System.out.println( preparedStatement );
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                account.setId( (long) rs.getInt( "id" ) );
                account.setPassword( rs.getString( "password" ) );
                account.setFirstName( rs.getString( "first_Name" ) );
                account.setLastName( rs.getString( "last_Name" ) );
                account.setEmail( rs.getString( "email" ) );
                account.setPassword( rs.getString( "password" ) );
                account.setPhoneNumber( rs.getString( "phone_Number" ) );
                account.setIsEmailAlert( rs.getString( "is_email_alert" ) );
                account.setIsPhoneAlert( rs.getString( "is_phone_alert" ) );
            }
            return account;
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException( e );
        }
        // Step 4: try-with-resource statement will auto close the connection.
        //Else
        return null;
    }

    @Override
    public AccountEntity findByEmail(String emailToFind) {
        //Check database for existing
        String querey = "SELECT * FROM USER WHERE EMAIL = \'" + emailToFind + "\'";
        AccountEntity account = new AccountEntity();
        H2JDBCUtils utils = new H2JDBCUtils();
        try (Connection connection = utils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement( querey )) {
            System.out.println( preparedStatement );
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                account.setId( (long) rs.getInt( "id" ) );
                account.setPassword( rs.getString( "password" ) );
                account.setFirstName( rs.getString( "first_Name" ) );
                account.setLastName( rs.getString( "last_Name" ) );
                account.setEmail( rs.getString( "email" ) );
                account.setPassword( rs.getString( "password" ) );
                account.setPhoneNumber( rs.getString( "phone_Number" ) );
                account.setIsEmailAlert( rs.getString( "is_email_alert" ) );
                account.setIsPhoneAlert( rs.getString( "is_phone_alert" ) );
            }
            return account;
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException( e );
        }
        // Step 4: try-with-resource statement will auto close the connection.
        //Else
        return null;
    }

    @Override
    public AccountEntity findByPhoneNumber(String phoneNumber) {
        //Check database for existing
        String querey = "SELECT * FROM USER WHERE PHONE_NUMBER = \' " + phoneNumber + "\'";
        AccountEntity account = new AccountEntity();
        H2JDBCUtils utils = new H2JDBCUtils();
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement( querey )) {
            preparedStatement.setInt( 1, 1 );
            System.out.println( preparedStatement );
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                account.setId( (long) rs.getInt( "id" ) );
                account.setPassword( rs.getString( "password" ) );
                account.setFirstName( rs.getString( "first_Name" ) );
                account.setLastName( rs.getString( "last_Name" ) );
                account.setEmail( rs.getString( "email" ) );
                account.setPassword( rs.getString( "password" ) );
                account.setPhoneNumber( rs.getString( "phone_Number" ) );
                account.setIsEmailAlert( rs.getString( "is_email_alert" ) );
                account.setIsPhoneAlert( rs.getString( "is_phone_alert" ) );
            }
            return account;
        } catch (SQLException e) {
            H2JDBCUtils.printSQLException( e );
        }
        // Step 4: try-with-resource statement will auto close the connection.
        //Else
        return null;
    }
    //Unimplemented methods

    @Override
    public <S extends AccountEntity> S save(S s) {
        return null;
    }

    @Override
    public <S extends AccountEntity> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<AccountEntity> findById(Long Id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<AccountEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<AccountEntity> findAllById(Iterable<Long> iterable) {
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
    public void delete(AccountEntity accountEntity) {

    }

    @Override
    public void deleteAll(Iterable<? extends AccountEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }

}
