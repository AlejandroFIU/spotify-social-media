package com.spotifysocialmedia.SSMApplication.Models;

public class Users {
    private int userID;
    private String name;
    private String email;
    private String username;
    private String password;
    private boolean isSilenced;
    private boolean isMod;

    public Users(int userID, String name, String email, String username, String password, boolean isSilenced, boolean isMod) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.isSilenced = isSilenced;
        this.isMod = isMod;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSilenced() {
        return isSilenced;
    }

    public void setSilence(boolean silence) {
        isSilenced = silence;
    }

    public boolean isMod() {
        return isMod;
    }

    public void setMod(boolean mod) {
        isMod = mod;
    }
}
