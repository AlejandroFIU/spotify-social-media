package com.spotifysocialmedia.SSMApplication.Models;

import java.sql.Date;

public class Posts {
    private int postID;
    private int userID;
    private String postText;
    private int likes;
    private int dislikes;
    private String artist;
    private String album;
    private String song;
    private boolean isDeleted;
    private Date createdOn;
    private Date updatedOn;

    public Posts(int postID, int userID, String postText, int likes, int dislikes, String artist, String album, String song, boolean isDeleted, Date createdOn, Date updatedOn) {
        this.postID = postID;
        this.userID = userID;
        this.postText = postText;
        this.likes = likes;
        this.dislikes = dislikes;
        this.artist = artist;
        this.album = album;
        this.song = song;
        this.isDeleted = isDeleted;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }
}
