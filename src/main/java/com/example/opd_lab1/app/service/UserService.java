package com.example.opd_lab1.app.service;


import com.example.opd_lab1.app.dao.UserDAO;
import com.example.opd_lab1.app.entities.Expert;
import com.example.opd_lab1.app.entities.User;
import com.example.opd_lab1.app.util.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class UserService implements UserDAO {

    private Connection connection = new DbConnect().getConnection();


    @Override
    public void add(User user) throws SQLException {
//        PreparedStatement preparedStatement = connection.prepareStatement();
    }


    @Override
    public LinkedList<User> getAllUsers() throws SQLException {
        String sql = "SELECT * FROM users;";
        LinkedList<User> users = new LinkedList<>();
        try (PreparedStatement prepareStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String login = resultSet.getString(2);
                String status = resultSet.getString(4);
                users.add(new User(id, login, null, status));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getUserById(int id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id=" + id;
        User user = new User();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user.setId(id);
            user.setLogin(resultSet.getString(2));
            user.setPassword(null);
            user.setStatus(resultSet.getString(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        String sql = "SELECT * FROM users WHERE login=(?)";
        User user = new User();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user.setId(resultSet.getInt(1));
            user.setLogin(resultSet.getString(2));
            user.setPassword(null);
            user.setStatus(resultSet.getString(4));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void update(Expert evaluation) {

    }

    @Override
    public void remove(Integer id) {

    }
}
