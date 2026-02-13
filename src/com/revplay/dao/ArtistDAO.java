package com.revplay.dao;

public interface ArtistDAO {
    void addSong(int id, String title,  String genre, String artist);
    void removeSong(int songId);
    void aboutArtist(String name);
}

