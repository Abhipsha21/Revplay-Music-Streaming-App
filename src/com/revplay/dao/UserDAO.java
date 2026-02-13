package com.revplay.dao;

public interface  UserDAO {
    boolean registerUser(String username, String password);
    boolean loginUser(String username, String password);
}


