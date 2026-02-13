package com.revplay.util;

import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        Connection con = DBConnection.getConnection();
        if (con != null) {
            System.out.println("✅ Connected to Oracle DB successfully!");
        } else {
            System.out.println("❌ Failed to connect to Oracle DB.");
        }
    }
}

