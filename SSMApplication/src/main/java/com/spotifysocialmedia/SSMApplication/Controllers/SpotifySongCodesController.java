package com.spotifysocialmedia.SSMApplication.Controllers;

import com.spotifysocialmedia.SSMApplication.ConnectionFactory.DBConnection;
import com.spotifysocialmedia.SSMApplication.Models.SpotifySongCodes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;

@RestController
public class SpotifySongCodesController {
    private DBConnection dbConnection;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private SpotifySongCodes spotifySongCode;

    @GetMapping("spotify/songs/all")
    public @ResponseBody ArrayList<SpotifySongCodes> getAllSpotifyAlbums() throws SQLException {
        dbConnection = new DBConnection();
        connection = dbConnection.connectionFactory();
        ArrayList<SpotifySongCodes> spotifySongCodes = new ArrayList<SpotifySongCodes>();
        String artist, album, song, songcode, songcovercode;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from spotifysongcodes;");
            while (resultSet.next()) {
                artist = resultSet.getString("artist");
                album = resultSet.getString("album");
                song = resultSet.getString("song");
                songcode = resultSet.getString("songcode");
                songcovercode = resultSet.getString("songcovercode");
                spotifySongCode = new SpotifySongCodes(artist, album, song, songcode, songcovercode);
                spotifySongCodes.add(spotifySongCode);
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

        return spotifySongCodes;
    }
}
