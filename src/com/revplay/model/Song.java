package com.revplay.model;

public class Song {

    private int songId;
    private String title;
    private String genre;
    private String artist;
    private int playCount;
    private String trending;

    public Song() {
    }

    public Song(int songId, String title, String genre,
                String artist, int playCount, String trending) {
        this.songId = songId;
        this.title = title;
        this.genre = genre;
        this.artist = artist;
        this.playCount = playCount;
        this.trending = trending;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public String getTrending() {
        return trending;
    }

    public void setTrending(String trending)  {
        this.trending = trending;
    }
}
