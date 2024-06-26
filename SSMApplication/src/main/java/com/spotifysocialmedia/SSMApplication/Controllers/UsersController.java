package com.spotifysocialmedia.SSMApplication.Controllers;

import com.spotifysocialmedia.SSMApplication.ConnectionFactory.DBConnection;
import com.spotifysocialmedia.SSMApplication.Models.Users;
import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;


@RestController
public class UsersController {
    private DBConnection dbConnection;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Users user;

    @GetMapping("users/validate")
    public ResponseEntity<String> validateUserCredentials(@RequestHeader("username") String uname, @RequestHeader("password") String pword) throws SQLException{
        dbConnection = new DBConnection();
        connection = dbConnection.connectionFactory();
        String username;
        boolean isValid = false;
        try {
            preparedStatement = connection.prepareStatement("select username from users where username = ? AND password = ?;");
            preparedStatement.clearParameters();
            preparedStatement.setString(1, uname);
            preparedStatement.setString(2, pword);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                username = resultSet.getString("username");
                if (username == null)
                    return new ResponseEntity<>("failed", HttpStatusCode.valueOf(HttpStatus.SC_NOT_FOUND));

                if (username.toLowerCase().trim().equals(uname.toLowerCase().trim()))
                    isValid = true;
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (resultSet != null)
                resultSet.close();
            if (preparedStatement != null)
                preparedStatement.close();
            if (connection != null)
                connection.close();
        }
        if (!isValid)
            return new ResponseEntity<>("failed", HttpStatusCode.valueOf(HttpStatus.SC_BAD_GATEWAY));

        return new ResponseEntity<>(uname, HttpStatusCode.valueOf(HttpStatus.SC_SUCCESS));
    }

    @GetMapping("/users/all")
    public @ResponseBody ArrayList<Users> getAllUsers() throws SQLException {
        dbConnection = new DBConnection();
        connection = dbConnection.connectionFactory();
        ArrayList<Users> users = new ArrayList<Users>();
        int userID, silence, mod;
        String name, email, username, password;
        boolean isSilenced = false, isMod = false;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from users;");
            while (resultSet.next()) {
                userID = resultSet.getInt("userID");
                name = resultSet.getString("name");
                email = resultSet.getString("email");
                username = resultSet.getString("username");
                password = resultSet.getString("password");
                silence = resultSet.getInt("isSilenced");
                mod = resultSet.getInt("isMod");
                if (silence == 1)
                    isSilenced = true;
                if (mod == 1)
                    isMod = true;
                user = new Users(userID, name, email, username, password, isSilenced, isMod);
                users.add(user);
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        }

        return users;
    }

    @GetMapping("/users/username/{uname}")
    public @ResponseBody Users getUserByUsername(@PathVariable("uname") String uname) throws SQLException {
        dbConnection = new DBConnection();
        connection = dbConnection.connectionFactory();
        int userID, silence, mod;
        String name, email, username, password = "";
        boolean isSilenced = false, isMod = false;
        try {
            preparedStatement = connection.prepareStatement("select userID, name, email, username, isSilenced, isMod from users where username = ?;");
            preparedStatement.clearParameters();
            preparedStatement.setString(1, uname);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userID = resultSet.getInt("userID");
                name = resultSet.getString("name");
                email = resultSet.getString("email");
                username = resultSet.getString("username");
                silence = resultSet.getInt("isSilenced");
                mod = resultSet.getInt("isMod");
                if (silence == 1)
                    isSilenced = true;
                if (mod == 1)
                    isMod = true;
                user = new Users(userID, name, email, username, password, isSilenced, isMod);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (resultSet != null)
                resultSet.close();
            if (preparedStatement != null)
                preparedStatement.close();
            if (connection != null)
                connection.close();
        }

        return user;
    }

    @GetMapping("/users/userid/{id}")
    public @ResponseBody Users getUserById(@PathVariable("id") int id) throws SQLException {
        dbConnection = new DBConnection();
        connection = dbConnection.connectionFactory();
        int userID, silence, mod;
        String name, email, username, password = "";
        boolean isSilenced = false, isMod = false;
        try {
            preparedStatement = connection.prepareStatement("select userID, name, email, username, isSilenced, isMod from users where userID = ?;");
            preparedStatement.clearParameters();
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userID = resultSet.getInt("userID");
                name = resultSet.getString("name");
                email = resultSet.getString("email");
                username = resultSet.getString("username");
                silence = resultSet.getInt("isSilenced");
                mod = resultSet.getInt("isMod");
                if (silence == 1)
                    isSilenced = true;
                if (mod == 1)
                    isMod = true;
                user = new Users(userID, name, email, username, password, isSilenced, isMod);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (resultSet != null)
                resultSet.close();
            if (preparedStatement != null)
                preparedStatement.close();
            if (connection != null)
                connection.close();
        }

        return user;
    }

    @PutMapping("users/moderator/silence/{username}/{isSilenced}")
    public void userSilencing(@PathVariable("username") String username, @PathVariable("isSilenced") boolean silenced) throws SQLException {
        dbConnection = new DBConnection();
        connection = dbConnection.connectionFactory();
        int isSilenced = 0;
        if(silenced)
            isSilenced = 1;
        try {
            statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate("update users set isSilenced = "+ isSilenced +" where username = '"+ username +"';");
            if (rowsAffected > 0) {
                System.out.println("Success");
            } else {
                System.out.println("Failed");
            }
            //resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        }
    }
}
