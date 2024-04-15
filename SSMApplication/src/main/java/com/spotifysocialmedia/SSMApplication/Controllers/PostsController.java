package com.spotifysocialmedia.SSMApplication.Controllers;

import com.spotifysocialmedia.SSMApplication.ConnectionFactory.DBConnection;
import com.spotifysocialmedia.SSMApplication.Models.Posts;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
            resultSet = statement.executeQuery("select * from posts;");
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
            resultSet = statement.executeQuery("select * from posts where artist = '" + artistName + "' order by createdOn desc;");
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

    @GetMapping("posts/artist/{artistname}/album/{albumname}")
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
            resultSet = statement.executeQuery("select * from posts where artist = '" + artistName + "' AND album = '" + albumName +"' order by createdOn desc;");
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

    @GetMapping("posts/artist/{artistname}/album/{songname}")
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
            resultSet = statement.executeQuery("select * from posts where artist = '" + artistName + "' AND song = '" + songName +"' order by createdOn desc;");
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
}
