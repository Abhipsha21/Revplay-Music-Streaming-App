package com.revplay.service;

import com.revplay.dao.*;

public class   LoginServiceImpl implements LoginService {

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public boolean loginUser(String username, String password) {
        return userDAO.loginUser(username, password);
    }
}

