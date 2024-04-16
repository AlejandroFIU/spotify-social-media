package com.spotifysocialmedia.SSMApplication.Controllers;

import com.spotifysocialmedia.SSMApplication.ConnectionFactory.DBConnection;
import com.spotifysocialmedia.SSMApplication.Models.Replies;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            resultSet = statement.executeQuery("select * from replies, users where users.isSilenced = 0 AND replies.isDeleted = 0;");
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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
            resultSet = statement.executeQuery("select * from replies, users where users.isSilenced = 0 AND replies.postID = '" + id + "' AND replies.isDeleted = 0 order by createdOn desc;");
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
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        }

        return replies;
    }


    /*
    * JSON Body
    *   {
            "replyID": 1,
            "postID": 1,
            "userID": 1,
            "replyText": "I am serious.",
            "likes": 0,
            "dislikes": 0,
            "createdOn": "2024-04-02",
            "updatedOn": null,
            "deleted": 0
        }
    * */
    @PostMapping("replies/new/reply")
    public ResponseEntity<Replies> postReply(@RequestBody Replies postReply) throws SQLException {
        if (postReply == null)
            return ResponseEntity.notFound().build();
        dbConnection = new DBConnection();
        connection = dbConnection.connectionFactory();
        try {
            statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate("INSERT INTO replies VALUES(\n" +
                    "    DEFAULT, " + postReply.getPostID() + ", " + postReply.getUserID() + ", '" + postReply.getreplyText() + "', DEFAULT, DEFAULT, DEFAULT, DEFAULT, NULL\n" +
                    ");");
            if (rowsAffected > 0) {
                System.out.println("Success");
            } else {
                System.out.println("Failed");
            }
            //resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        }

        return ResponseEntity.ok(postReply);
    }

    @PutMapping("replies/likes/{replyID}")
    public void updateRLikes(@PathVariable("replyID") int rID) throws SQLException {
        dbConnection = new DBConnection();
        connection = dbConnection.connectionFactory();

        try {
            statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate("update replies set likes = likes + 1 where replyID = " + rID + ";");
            if (rowsAffected > 0) {
                System.out.println("Success");
            } else {
                System.out.println("Failed");
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        }
    }


    @PutMapping("replies/dislikes/{replyID}")
    public void updateRDislikes(@PathVariable("replyID") int rID) throws SQLException {
        dbConnection = new DBConnection();
        connection = dbConnection.connectionFactory();

        try {
            statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate("update replies set dislikes = dislikes + 1 where replyID = " + rID + ";");
            if (rowsAffected > 0) {
                System.out.println("Success");
            } else {
                System.out.println("Failed");
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        }
    }

    @PutMapping("replies/delete/{replyID}")
    public void deleteReplyByID(@PathVariable("replyID") int id) throws SQLException {
        dbConnection = new DBConnection();
        connection = dbConnection.connectionFactory();

        try {
            statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate("update replies set isDeleted = 1 where replyID = " + id + ";");
            if (rowsAffected > 0) {
                System.out.println("Success");
            } else {
                System.out.println("Failed");
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        }
    }
}
