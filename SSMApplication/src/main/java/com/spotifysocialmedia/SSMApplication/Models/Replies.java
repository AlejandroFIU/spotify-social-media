package com.spotifysocialmedia.SSMApplication.Models;

import java.util.Date;

public class Replies {
    private int replyID;
    private int postID;
    private int userID;
    private String replyText;
    private int likes;
    private int dislikes;
    private boolean isDeleted;
    private Date createdOn;
    private Date updatedOn;

    public Replies(int replyID, int postID, int userID, String replyText, int likes, int dislikes, boolean isDeleted, Date createdOn, Date updatedOn) {
        this.replyID = replyID;
        this.postID = postID;
        this.userID = userID;
        this.replyText = replyText;
        this.likes = likes;
        this.dislikes = dislikes;
        this.isDeleted = isDeleted;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public int getReplyID() {
        return replyID;
    }

    public void setReplyID(int replyID) {
        this.replyID = replyID;
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

    public String getreplyText() {
        return replyText;
    }

    public void setreplyText(String replyText) {
        this.replyText = replyText;
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
