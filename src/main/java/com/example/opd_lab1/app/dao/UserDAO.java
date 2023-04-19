package com.example.opd_lab1.app.dao;

import com.example.opd_lab1.app.entities.Expert;
import com.example.opd_lab1.app.entities.User;

import java.sql.SQLException;
import java.util.LinkedList;

public interface UserDAO {

    void add(User user) throws SQLException;

    LinkedList<User> getAllUsers() throws SQLException;

    User getUserById(int id) throws SQLException;
    User getUserByLogin(String login);
    void update(Expert evaluation);

    void remove(Integer id);
}
