package com.example.opd_lab1.app.service;

import com.example.opd_lab1.app.dao.TestDAO;
import com.example.opd_lab1.app.entities.Test;
import com.example.opd_lab1.app.util.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class TestService implements TestDAO {

    Connection connection = new DbConnect().getConnection();

    @Override
    public LinkedList<Test> getAllResults() {
        String sql = "SELECT * FROM tests;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            LinkedList<Test> tests = new LinkedList<>();
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                Integer userId = resultSet.getInt(2);
                Integer testId = resultSet.getInt(3);
                Double time = resultSet.getDouble(4);
                Double correctAnswer = resultSet.getDouble(5);
                tests.add(new Test(id, userId, testId, time, correctAnswer));
            }
            return tests;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public LinkedList<Test> getResultsByUserId(Integer userId) throws SQLException {
        String sql = "SELECT * FROM tests WHERE userId=(?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            LinkedList<Test> tests = new LinkedList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int testId = resultSet.getInt(3);
                double time = resultSet.getDouble(4);
                double correctAnswers = resultSet.getDouble(5);
                tests.add(new Test(id, userId, testId, time, correctAnswers));
            }
            return tests;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public LinkedList<Test> getResultsByTestId(Integer testId) {
        String sql = "SELECT * FROM tests WHERE testId=(?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, testId);
            ResultSet resultSet = preparedStatement.executeQuery();
            LinkedList<Test> tests = new LinkedList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int userId = resultSet.getInt(2);
                double time = resultSet.getDouble(4);
                double correctAnswers = resultSet.getDouble(5);
                tests.add(new Test(id, userId, testId, time, correctAnswers));
            }
            return tests;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public LinkedList<Test> getResultsByUserIdAndTestId(Integer userId, Integer testId) {
        String sql = "SELECT * FROM tests WHERE userId=(?) AND testId=(?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, testId);
            ResultSet resultSet = preparedStatement.executeQuery();
            LinkedList<Test> tests = new LinkedList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                double time = resultSet.getDouble(4);
                double correctAnswers = resultSet.getDouble(5);
                tests.add(new Test(id, userId, testId, time, correctAnswers));
            }
            return tests;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
