package com.revplay.dao;

import java.sql.*;
import com.revplay.util.DBConnection;

public class ArtistDAOImpl implements ArtistDAO {

    Connection con = DBConnection.getConnection();

    @Override
    public void addSong(int id, String title, String genre, String artist) {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO song(song_id, title, artist, genre_id) VALUES (?, ?, ?, ?)");
            ps.setInt(1, id);

            ps.setString(2, title);
            ps.setString(3, artist);

            // Get genre_id
            PreparedStatement ps2  = con.prepareStatement("SELECT genre_id FROM genre WHERE genre_name=?");
            ps2.setString(1, genre);
            ResultSet rs = ps2.executeQuery();
            if(rs.next()) ps.setInt(4, rs.getInt("genre_id"));
            else { System.out.println("❌ Genre not found!"); return; }

            ps.executeUpdate();
            System.out.println("✅ Song added successfully");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void removeSong(int songId) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM song WHERE song_id=?");
            ps.setInt(1, songId);
            ps.executeUpdate();
            System.out.println("✅ Song removed");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void aboutArtist(String name) {
        System.out.println("Artist Name : " + name);
        System.out.println("Platform    : RevPlay");
    }
}
