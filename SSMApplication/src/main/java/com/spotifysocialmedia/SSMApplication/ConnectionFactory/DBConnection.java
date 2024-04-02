package com.spotifysocialmedia.SSMApplication.ConnectionFactory;

import java.sql.*;

public class DBConnection {
    private Connection connection;
    public DBConnection(){
        connection = null;
    }

    public Connection connectionFactory(){
        try{
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssmdb","root", "");
        }catch (Exception e){
            e.printStackTrace();
        }

        return connection;
    }
}
