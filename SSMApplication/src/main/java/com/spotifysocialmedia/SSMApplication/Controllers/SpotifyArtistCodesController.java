package com.spotifysocialmedia.SSMApplication.Controllers;

import com.spotifysocialmedia.SSMApplication.ConnectionFactory.DBConnection;
import com.spotifysocialmedia.SSMApplication.Models.SpotifyArtistCodes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;

@RestController
public class SpotifyArtistCodesController {
    private DBConnection dbConnection;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private SpotifyArtistCodes spotifyArtistCode;

    @GetMapping("spotify/artists/all")
    public @ResponseBody ArrayList<SpotifyArtistCodes> getAllSpotifyArtists() throws SQLException {
        dbConnection = new DBConnection();
        connection = dbConnection.connectionFactory();
        ArrayList<SpotifyArtistCodes> spotifyArtistCodes = new ArrayList<SpotifyArtistCodes>();
        String artist, artistcode, artistcovercode;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from spotifyartistcodes;");
            while (resultSet.next()) {
                artist = resultSet.getString("artist");
                artistcode = resultSet.getString("artistcode");
                artistcovercode = resultSet.getString("artistcovercode");
                spotifyArtistCode = new SpotifyArtistCodes(artist, artistcode, artistcovercode);
                spotifyArtistCodes.add(spotifyArtistCode);
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

        return spotifyArtistCodes;
    }
}
