package com.spotifysocialmedia.SSMApplication.Controllers;

import com.spotifysocialmedia.SSMApplication.ConnectionFactory.DBConnection;
import com.spotifysocialmedia.SSMApplication.Models.Replies;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;

@RestController
public class RepliesController {
    private DBConnection dbConnection;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Replies reply;

    @GetMapping("replies/all")
    public @ResponseBody ArrayList<Replies> getAllReplies() throws SQLException {
        dbConnection = new DBConnection();
        connection = dbConnection.connectionFactory();
        ArrayList<Replies> replies = new ArrayList<Replies>();
        int replyID, postID, userID, likes, dislikes, deleted;
        String replyText, artist, album, song;
        boolean isDeleted = false;
        Date createdOn, updatedOn;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from replies;");
            while (resultSet.next()) {
                replyID = resultSet.getInt("replyID");
                postID = resultSet.getInt("postID");
                userID = resultSet.getInt("userID");
                replyText = resultSet.getString("replyText");
                likes = resultSet.getInt("likes");
                dislikes = resultSet.getInt("dislikes");
                deleted = resultSet.getInt("isDeleted");
                createdOn = resultSet.getDate("createdOn");
                updatedOn = resultSet.getDate("updatedOn");
                if (deleted == 1)
                    isDeleted = true;
                reply = new Replies(replyID, postID, userID, replyText, likes, dislikes, isDeleted, createdOn, updatedOn);
                replies.add(reply);
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

        return replies;
    }

    @GetMapping("replies/post/{postID}")
    public @ResponseBody ArrayList<Replies> getAllRepliesByPost(@PathVariable("postID") int id) throws SQLException {
        dbConnection = new DBConnection();
        connection = dbConnection.connectionFactory();
        ArrayList<Replies> replies = new ArrayList<Replies>();
        int replyID, postID, userID, likes, dislikes, deleted;
        String replyText, artist, album, song;
        boolean isDeleted = false;
        Date createdOn, updatedOn;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from replies where postID = '" + id + "' order by createdOn desc;");
            while (resultSet.next()) {
                replyID = resultSet.getInt("replyID");
                postID = resultSet.getInt("postID");
                userID = resultSet.getInt("userID");
                replyText = resultSet.getString("replyText");
                likes = resultSet.getInt("likes");
                dislikes = resultSet.getInt("dislikes");
                deleted = resultSet.getInt("isDeleted");
                createdOn = resultSet.getDate("createdOn");
                updatedOn = resultSet.getDate("updatedOn");
                if (deleted == 1)
                    isDeleted = true;
                reply = new Replies(replyID, postID, userID, replyText, likes, dislikes, isDeleted, createdOn, updatedOn);
                replies.add(reply);
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

        return replies;
    }
}
