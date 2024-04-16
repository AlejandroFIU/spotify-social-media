package com.spotifysocialmedia.SSMApplication.Controllers;

import com.spotifysocialmedia.SSMApplication.ConnectionFactory.DBConnection;
import com.spotifysocialmedia.SSMApplication.Models.Posts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;

@RestController
public class PostsController {
    private DBConnection dbConnection;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Posts post;

    @GetMapping("posts/all")
    public @ResponseBody ArrayList<Posts> getAllPosts() throws SQLException {
        dbConnection = new DBConnection();
        connection = dbConnection.connectionFactory();
        ArrayList<Posts> posts = new ArrayList<Posts>();
        int postID, userID, likes, dislikes, deleted;
        String postText, artist, album, song;
        boolean isDeleted = false;
        Date createdOn, updatedOn;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from posts, users where users.isSilenced = 0 AND posts.isDeleted = 0;");
            while (resultSet.next()) {
                postID = resultSet.getInt("postID");
                userID = resultSet.getInt("userID");
                postText = resultSet.getString("postText");
                likes = resultSet.getInt("likes");
                dislikes = resultSet.getInt("dislikes");
                artist = resultSet.getString("artist");
                album = resultSet.getString("album");
                song = resultSet.getString("song");
                deleted = resultSet.getInt("isDeleted");
                createdOn = resultSet.getDate("createdOn");
                updatedOn = resultSet.getDate("updatedOn");
                if (deleted == 1)
                    isDeleted = true;
                post = new Posts(postID, userID, postText, likes, dislikes, artist, album, song, isDeleted, createdOn, updatedOn);
                posts.add(post);
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

        return posts;
    }

    @GetMapping("posts/artist/{artistname}")
    public @ResponseBody ArrayList<Posts> getAllPostsByArtist(@PathVariable("artistname") String artistName) throws SQLException {
        dbConnection = new DBConnection();
        connection = dbConnection.connectionFactory();
        ArrayList<Posts> posts = new ArrayList<Posts>();
        int postID, userID, likes, dislikes, deleted;
        String postText, artist, album, song;
        boolean isDeleted = false;
        Date createdOn, updatedOn;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from posts, users where users.isSilenced = 0 AND posts.artist = '" + artistName + "' AND posts.isDeleted = 0 order by createdOn desc;");
            while (resultSet.next()) {
                postID = resultSet.getInt("postID");
                userID = resultSet.getInt("userID");
                postText = resultSet.getString("postText");
                likes = resultSet.getInt("likes");
                dislikes = resultSet.getInt("dislikes");
                artist = resultSet.getString("artist");
                album = resultSet.getString("album");
                song = resultSet.getString("song");
                deleted = resultSet.getInt("isDeleted");
                createdOn = resultSet.getDate("createdOn");
                updatedOn = resultSet.getDate("updatedOn");
                if (deleted == 1)
                    isDeleted = true;
                post = new Posts(postID, userID, postText, likes, dislikes, artist, album, song, isDeleted, createdOn, updatedOn);
                posts.add(post);
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

        return posts;
    }

    @GetMapping(value = "posts/album/{artistname}/{albumname}")
    public @ResponseBody ArrayList<Posts> getAllPostsByAlbum(@PathVariable("artistname") String artistName, @PathVariable("albumname") String albumName) throws SQLException {
        dbConnection = new DBConnection();
        connection = dbConnection.connectionFactory();
        ArrayList<Posts> posts = new ArrayList<Posts>();
        int postID, userID, likes, dislikes, deleted;
        String postText, artist, album, song;
        boolean isDeleted = false;
        Date createdOn, updatedOn;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from posts, users where users.isSilenced = 0 AND posts.artist = '" + artistName + "' AND posts.album = '" + albumName +"' AND posts.isDeleted = 0 order by createdOn desc;");
            while (resultSet.next()) {
                postID = resultSet.getInt("postID");
                userID = resultSet.getInt("userID");
                postText = resultSet.getString("postText");
                likes = resultSet.getInt("likes");
                dislikes = resultSet.getInt("dislikes");
                artist = resultSet.getString("artist");
                album = resultSet.getString("album");
                song = resultSet.getString("song");
                deleted = resultSet.getInt("isDeleted");
                createdOn = resultSet.getDate("createdOn");
                updatedOn = resultSet.getDate("updatedOn");
                if (deleted == 1)
                    isDeleted = true;
                post = new Posts(postID, userID, postText, likes, dislikes, artist, album, song, isDeleted, createdOn, updatedOn);
                posts.add(post);
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

        return posts;
    }

    @GetMapping(value = "posts/song/{artistname}/{songname}")
    public @ResponseBody ArrayList<Posts> getAllPostsBySong(@PathVariable("artistname") String artistName, @PathVariable("songname") String songName) throws SQLException {
        dbConnection = new DBConnection();
        connection = dbConnection.connectionFactory();
        ArrayList<Posts> posts = new ArrayList<Posts>();
        int postID, userID, likes, dislikes, deleted;
        String postText, artist, album, song;
        boolean isDeleted = false;
        Date createdOn, updatedOn;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from posts, users where users.isSilenced = 0 AND posts.artist = '" + artistName + "' AND posts.song = '" + songName +"' AND posts.isDeleted = 0 order by createdOn desc;");
            while (resultSet.next()) {
                postID = resultSet.getInt("postID");
                userID = resultSet.getInt("userID");
                postText = resultSet.getString("postText");
                likes = resultSet.getInt("likes");
                dislikes = resultSet.getInt("dislikes");
                artist = resultSet.getString("artist");
                album = resultSet.getString("album");
                song = resultSet.getString("song");
                deleted = resultSet.getInt("isDeleted");
                createdOn = resultSet.getDate("createdOn");
                updatedOn = resultSet.getDate("updatedOn");
                if (deleted == 1)
                    isDeleted = true;
                post = new Posts(postID, userID, postText, likes, dislikes, artist, album, song, isDeleted, createdOn, updatedOn);
                posts.add(post);
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

        return posts;
    }

    /*
    JSON Body
        {
                "postID": 1,
                "userID": 3,
                "postText": "Taylor can do no wrong OMG!!!",
                "likes": 0,
                "dislikes": 0,
                "artist": "Taylor Swift",
                "album": null,
                "song": null,
                "createdOn": "2024-04-15",
                "updatedOn": null,
                "deleted": false
        }
    */

    @PostMapping("posts/new/post")
    public ResponseEntity<Posts> postReply(@RequestBody Posts postThread) throws SQLException {
        if (postThread == null)
            return ResponseEntity.notFound().build();
        dbConnection = new DBConnection();
        connection = dbConnection.connectionFactory();
        try {
            statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate("INSERT INTO posts VALUES(\n" +
                    "    DEFAULT, " + postThread.getUserID() + ", '" + postThread.getPostText() + "', DEFAULT, DEFAULT, '"+ postThread.getArtist() +"', '"+ postThread.getAlbum() +"', '"+ postThread.getSong() +"', DEFAULT, DEFAULT, NULL\n" +
                    ");");
            if (rowsAffected > 0){
                System.out.println("Success");
            }else{
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

        return ResponseEntity.ok(postThread);
    }

    @PutMapping("posts/likes/{postID}")
    public void updatePLikes(@PathVariable("postID") int pID) throws SQLException {
        dbConnection = new DBConnection();
        connection = dbConnection.connectionFactory();

        try {
            statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate("update posts set likes = likes + 1 where postID = " + pID + ";");
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

    @PutMapping("posts/dislikes/{postID}")
    public void updatePDislikes(@PathVariable("postID") String pID) throws SQLException {
            dbConnection = new DBConnection();
            connection = dbConnection.connectionFactory();

            try {
                statement = connection.createStatement();
                int rowsAffected = statement.executeUpdate("update posts set dislikes = dislikes + 1 where postID = " + pID + ";");
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
