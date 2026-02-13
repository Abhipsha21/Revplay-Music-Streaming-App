package com.revplay.dao;

public interface PlaylistDAO {
    void viewMyPlaylists(String username);
    void createPlaylist(String username, String name, String description);
    void addSongToPlaylist(int playlistId, int songId);
    void removeSongFromPlaylist(int playlistId, int songId);
}

