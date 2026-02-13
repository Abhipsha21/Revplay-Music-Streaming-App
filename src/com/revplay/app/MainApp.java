package com.revplay.app;

import java.util.Scanner;
import com.revplay.service.*;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n========= REVPLAY =========");
            System.out.println("1. User Login");
            System.out.println("2. Artist Login");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter username: ");
                String username = sc.nextLine();
                System.out.print("Enter password: ");
                String password = sc.nextLine();

                LoginService loginService = new LoginServiceImpl();
                if (loginService.loginUser(username, password)) {
                    new UserServiceImpl().userMenu(username);
                } else {
                    System.out.println("❌ Invalid username or password");
                }

            } else if (choice == 2) {
                System.out.print("Enter artist name: ");
                String artistName = sc.nextLine();
                new ArtistServiceImpl().artistMenu(artistName);

            } else if (choice == 3) {
                System.out.println("👋 Exiting...");
                System.exit(0);
            } else {
                System.out.println("❌ Invalid choice");
            }
        }
    }
}
