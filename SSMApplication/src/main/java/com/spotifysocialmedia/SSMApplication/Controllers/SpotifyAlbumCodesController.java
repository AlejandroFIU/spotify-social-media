package com.spotifysocialmedia.SSMApplication.Controllers;

import com.spotifysocialmedia.SSMApplication.ConnectionFactory.DBConnection;
import com.spotifysocialmedia.SSMApplication.Models.SpotifyAlbumCodes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;

@RestController
public class SpotifyAlbumCodesController {
    private DBConnection dbConnection;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private SpotifyAlbumCodes spotifyAlbumCode;

    @GetMapping("spotify/albums/all")
    public @ResponseBody ArrayList<SpotifyAlbumCodes> getAllSpotifyAlbums() throws SQLException {
        dbConnection = new DBConnection();
        connection = dbConnection.connectionFactory();
        ArrayList<SpotifyAlbumCodes> spotifyAlbumCodes = new ArrayList<SpotifyAlbumCodes>();
        String artist, album, albumcode, albumcovercode;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from spotifyalbumcodes;");
            while (resultSet.next()) {
                artist = resultSet.getString("artist");
                album = resultSet.getString("album");
                albumcode = resultSet.getString("albumcode");
                albumcovercode = resultSet.getString("albumcovercode");
                spotifyAlbumCode = new SpotifyAlbumCodes(artist, album, albumcode, albumcovercode);
                spotifyAlbumCodes.add(spotifyAlbumCode);
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

        return spotifyAlbumCodes;
    }
}
