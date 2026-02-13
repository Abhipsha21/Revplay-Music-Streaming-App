package com.revplay.dao;

import java.sql.*;
import com.revplay.util.DBConnection;

public class  UserDAOImpl implements UserDAO {

    Connection con = DBConnection.getConnection();

    @Override
    public boolean registerUser(String username, String password) {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO app_user(user_id, username, password) VALUES (app_user_seq.NEXTVAL, ?, ?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("⚠ Username already exists");
            return false;
        }
    }

    @Override
    public boolean loginUser(String username, String password) {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM app_user WHERE username=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
