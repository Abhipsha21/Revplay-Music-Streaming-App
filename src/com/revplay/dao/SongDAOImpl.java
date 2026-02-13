package com.revplay.dao;

import java.sql.*;
import com.revplay.util.DBConnection;

public class SongDAOImpl  implements SongDAO {

    Connection con = DBConnection.getConnection();

    @Override
    public void availableSongs() {
        try {
            ResultSet rs = con.createStatement()
                    .executeQuery("SELECT title, artist FROM song");
            System.out.println("\n🎵 Available Songs:");
            while (rs.next())
                System.out.println(rs.getString("title") + " - " + rs.getString("artist"));
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void genreWiseSongs(String genre) {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT s.title, s.artist FROM song s " +
                            "JOIN genre g ON s.genre_id = g.genre_id " +
                            "WHERE g.genre_name = ?");
            ps.setString(1, genre);
            ResultSet rs = ps.executeQuery();
            System.out.println("\n🎶 Songs in Genre: " + genre);
            while (rs.next())
                System.out.println(rs.getString("title") + " - " + rs.getString("artist"));
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void playSong(int songId) {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE song SET play_count = play_count + 1 WHERE song_id = ?");
            ps.setInt(1, songId);
            ps.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement(
                    "SELECT title, artist FROM song WHERE song_id = ?");
            ps2.setInt(1, songId);
            ResultSet rs = ps2.executeQuery();
            if (rs.next()) {
                System.out.println("\n▶ Playing: " + rs.getString("title") + " - " + rs.getString("artist"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void searchSong(String keyword) {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT title, artist FROM song WHERE LOWER(title) LIKE '%' || LOWER(?) || '%' " +
                            "OR LOWER(artist) LIKE '%' || LOWER(?) || '%'");
            ps.setString(1, keyword);
            ps.setString(2, keyword);
            ResultSet rs = ps.executeQuery();
            System.out.println("\n🔍 Search Results for: " + keyword);
            while (rs.next())
                System.out.println(rs.getString("title") + " - " + rs.getString("artist"));
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void weeklyTopSongs() {
        try {
            ResultSet rs = con.createStatement().executeQuery(
                    "SELECT title, artist, play_count FROM song ORDER BY play_count DESC FETCH FIRST 5 ROWS ONLY");
            System.out.println("\n🔥 Week’s Top Songs:");
            while (rs.next())
                System.out.println(rs.getString("title") + " - " + rs.getString("artist") +
                        " | Plays: " + rs.getInt("play_count"));
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void trendingSongs() {
        try {
            ResultSet rs = con.createStatement().executeQuery(
                    "SELECT title, artist FROM song WHERE trending = 'YES'");
            System.out.println("\n📈 Trending Songs:");
            while (rs.next())
                System.out.println(rs.getString("title") + " - " + rs.getString("artist"));
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
