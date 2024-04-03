package com.spotifysocialmedia.SSMApplication.Models;

public class SpotifyAlbumCodes {
    private String artist;
    private String album;
    private String albumCode;
    private String albumCoverCode;

    public SpotifyAlbumCodes(String artist, String album, String albumCode, String albumCoverCode) {
        this.artist = artist;
        this.album = album;
        this.albumCode = albumCode;
        this.albumCoverCode = albumCoverCode;
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

    public String getAlbumCode() {
        return albumCode;
    }

    public void setAlbumCode(String albumCode) {
        this.albumCode = albumCode;
    }

    public String getAlbumCoverCode() {
        return albumCoverCode;
    }

    public void setAlbumCoverCode(String albumCoverCode) {
        this.albumCoverCode = albumCoverCode;
    }
}
