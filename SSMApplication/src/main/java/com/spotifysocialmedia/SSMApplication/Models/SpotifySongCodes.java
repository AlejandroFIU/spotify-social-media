package com.spotifysocialmedia.SSMApplication.Models;

public class SpotifySongCodes {
    private String artist;
    private String album;
    private String song;
    private String songCode;
    private String songCoverCode;

    public SpotifySongCodes(String artist, String album, String song, String songCode, String songCoverCode) {
        this.artist = artist;
        this.album = album;
        this.song = song;
        this.songCode = songCode;
        this.songCoverCode = songCoverCode;
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

    public String getSongCode() {
        return songCode;
    }

    public void setSongCode(String songCode) {
        this.songCode = songCode;
    }

    public String getSongCoverCode() {
        return songCoverCode;
    }

    public void setSongCoverCode(String songCoverCode) {
        this.songCoverCode = songCoverCode;
    }
}
