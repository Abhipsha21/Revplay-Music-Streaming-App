package com.revplay.model;

public class Playlist {

    private int playlistId;
    private String username;
    private String name;
    private String description;

    public Playlist() {
    }

    public Playlist(int playlistId, String username,
                    String name, String description) {
        this.playlistId = playlistId;
        this.username = username;
        this.name = name;
        this.description = description;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
