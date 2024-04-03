package com.spotifysocialmedia.SSMApplication.Models;

public class SpotifyArtistCodes {
    private String artist;
    private String artistCode;
    private String artistCoverCode;

    public SpotifyArtistCodes(String artist, String artistCode, String artistCoverCode) {
        this.artist = artist;
        this.artistCode = artistCode;
        this.artistCoverCode = artistCoverCode;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtistCode() {
        return artistCode;
    }

    public void setArtistCode(String artistCode) {
        this.artistCode = artistCode;
    }

    public String getArtistCoverCode() {
        return artistCoverCode;
    }

    public void setArtistCoverCode(String artistCoverCode) {
        this.artistCoverCode = artistCoverCode;
    }
}
