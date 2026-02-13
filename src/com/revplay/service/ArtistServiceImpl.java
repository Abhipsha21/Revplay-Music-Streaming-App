package com.revplay.service;

import java.util.Scanner;
import com.revplay.dao.*;

public class ArtistServiceImpl implements ArtistService {

    private ArtistDAO artistDAO = new ArtistDAOImpl();
    private Scanner sc = new Scanner(System.in);

    @Override
    public void artistMenu(String artistName) {

        while (true) {
            System.out.println("\n========= ARTIST DASHBOARD =========");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. About Me");
            System.out.println("4. Logout");

            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Song ID: "); int id = sc.nextInt();
                    System.out.print("Title: "); String title = sc.next();
                    System.out.print("Genre: "); String genre = sc.next();
                    artistDAO.addSong(id, title, genre, artistName);
                }
                case 2 -> {
                    System.out.print("Song ID to remove: "); int id = sc.nextInt();
                    artistDAO.removeSong(id);
                }
                case 3 -> artistDAO.aboutArtist(artistName);
                case 4 -> { System.out.println(" Artist logged out"); return; }
                default -> System.out.println(" Invalid option");
            }
        }
    }
}
