package com.revplay.service;

import java.util.Scanner;
import com.revplay.dao.*;

public class UserServiceImpl implements UserService {

    private SongDAO songDAO = new SongDAOImpl();
    private PlaylistDAO playlistDAO = new PlaylistDAOImpl();
    private Scanner  sc = new Scanner(System.in);

    @Override
    public void userMenu(String username) {

        while (true) {
            System.out.println("\n========= USER DASHBOARD =========");
            System.out.println("1. Available Songs");
            System.out.println("2. Genre-wise Songs");
            System.out.println("3. Play Song");
            System.out.println("4. Search Song");
            System.out.println("5. Week’s Top Songs");
            System.out.println("6. Trending Songs");
            System.out.println("7. My Playlists");
            System.out.println("8. Logout");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> songDAO.availableSongs();
                case 2 -> { System.out.print("Enter genre: "); songDAO.genreWiseSongs(sc.next()); }
                case 3 -> { System.out.print("Song ID to play: "); songDAO.playSong(sc.nextInt()); }
                case 4 -> { System.out.print("Keyword: "); songDAO.searchSong(sc.next()); }
                case 5 -> songDAO.weeklyTopSongs();
                case 6 -> songDAO.trendingSongs();
                case 7 -> playlistMenu(username);
                case 8 -> { System.out.println(" Logged out"); return; }
                default -> System.out.println(" Invalid option");
            }
        }
    }

    private void playlistMenu(String username) {
        System.out.println("\n----- PLAYLIST MENU -----");
        System.out.println("1. View My Playlists");
        System.out.println("2. Create Playlist");
        System.out.println("3. Add Song to Playlist");
        System.out.println("4. Remove Song from Playlist");

        int ch = sc.nextInt();

        switch (ch) {
            case 1 -> playlistDAO.viewMyPlaylists(username);
            case 2 -> {
                System.out.print("Playlist name: "); String name = sc.next();
                playlistDAO.createPlaylist(username, name, "No description");
            }
            case 3 -> {
                System.out.print("Playlist ID: "); int pid = sc.nextInt();
                System.out.print("Song ID: "); int sid = sc.nextInt();
                playlistDAO.addSongToPlaylist(pid, sid);
            }
            case 4 -> {
                System.out.print("Playlist ID: "); int pid = sc.nextInt();
                System.out.print("Song ID: "); int sid = sc.nextInt();
                playlistDAO.removeSongFromPlaylist(pid, sid);
            }
        }
    }
}

