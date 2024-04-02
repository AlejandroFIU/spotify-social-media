package com.spotifysocialmedia.SSMApplication.Controllers;

import com.spotifysocialmedia.SSMApplication.ConnectionFactory.DBConnection;
import com.spotifysocialmedia.SSMApplication.Models.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


@RestController
public class UsersController {
    private DBConnection dbConnection;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private Users user;

    public UsersController(){
        dbConnection = new DBConnection();
        connection = dbConnection.connectionFactory();
    }

    @GetMapping("/users")
    public @ResponseBody ArrayList<Users> getAllUsers() throws SQLException {
        ArrayList<Users> users = new ArrayList<Users>();
        int userID, silence, mod;
        String name, email, username, password;
        boolean isSilenced = false, isMod = false;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                userID = resultSet.getInt("userID");
                name = resultSet.getString("name");
                email = resultSet.getString("email");
                username = resultSet.getString("username");
                password = resultSet.getString("name");
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
}
