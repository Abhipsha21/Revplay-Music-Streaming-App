package com.revplay.dao;

public interface SongDAO {
    void availableSongs();
    void genreWiseSongs(String genre);
    void playSong(int songId);
    void searchSong(String keyword);
    void weeklyTopSongs();
    void trendingSongs();
}


