package com.revplay.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:XE",
                    "music_app",
                    "music123"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}

