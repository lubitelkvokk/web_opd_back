package com.example.opd_lab1.app.service;

import com.example.opd_lab1.app.dao.ExpertDAO;
import com.example.opd_lab1.app.entities.Expert;
import com.example.opd_lab1.app.util.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class ExpertService implements ExpertDAO {

    Connection connection = new DbConnect().getConnection();

    @Override
    public void add(Expert expert) throws SQLException {

    }

    @Override
    public LinkedList<Expert> getAllExperts(int id) throws SQLException {
        return null;
    }

    @Override
    public Expert getExpertById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Expert expert = new Expert();
        String sql = "SELECT id, identifier, fio, relevance from experts";
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            expert.setId(resultSet.getInt(1));
            expert.setIdentifier(resultSet.getString(2));
            expert.setFio(resultSet.getString(3));
            expert.setRelevance(resultSet.getDouble(4));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return expert;
    }

    @Override
    public void update(Expert evaluation) {

    }

    @Override
    public void remove(Expert evaluation) {

    }

    @Override
    public void remove(Integer id) {

    }
}
