package com.revplay.dao;

import java.sql.*;
import com.revplay.util.DBConnection;

public class PlaylistDAOImpl implements PlaylistDAO {

    private Connection con =  DBConnection.getConnection();

    @Override
    public void viewMyPlaylists(String username) {
        String sql = "SELECT p.playlist_id, p.playlist_name " +
                "FROM playlist p JOIN app_user u ON p.user_id = u.user_id " +
                "WHERE u.username = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            System.out.println("Your Playlists:");
            while (rs.next())
                System.out.println("ID: " + rs.getInt("playlist_id") + ", Name: " + rs.getString("playlist_name"));
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void createPlaylist(String username, String name, String description) {
        try {
            String userSql = "SELECT user_id FROM app_user WHERE username = ?";
            PreparedStatement psUser = con.prepareStatement(userSql);
            psUser.setString(1, username);
            ResultSet rs = psUser.executeQuery();
            if (rs.next()) {
                int userId = rs.getInt("user_id");
                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO playlist(playlist_id, user_id, playlist_name) VALUES (playlist_seq.NEXTVAL, ?, ?)");
                ps.setInt(1, userId);
                ps.setString(2, name);
                ps.executeUpdate();
                System.out.println("✅ Playlist created!");
            } else {
                System.out.println("❌ User not found!");
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void addSongToPlaylist(int playlistId, int songId) {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO playlist_song(playlist_id, song_id) VALUES(?, ?)");
            ps.setInt(1, playlistId);
            ps.setInt(2, songId);
            ps.executeUpdate();
            System.out.println("✅ Song added to playlist!");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void removeSongFromPlaylist(int playlistId, int songId) {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM playlist_song WHERE playlist_id = ? AND song_id = ?");
            ps.setInt(1, playlistId);
            ps.setInt(2, songId);
            ps.executeUpdate();
            System.out.println("✅ Song removed from playlist!");
        } catch (SQLException e) { e.printStackTrace(); }
    }
}

