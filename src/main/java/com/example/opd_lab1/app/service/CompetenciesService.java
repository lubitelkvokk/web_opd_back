package com.example.opd_lab1.app.service;

import com.example.opd_lab1.app.dao.CompetenciesDAO;
import com.example.opd_lab1.app.entities.Competency;
import com.example.opd_lab1.app.entities.Evaluation;
import com.example.opd_lab1.app.util.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class CompetenciesService implements CompetenciesDAO {

    Connection connection = new DbConnect().getConnection();

    @Override
    public void add(Competency competency) throws SQLException {

    }

    @Override
    public LinkedList<Competency> getAllCompetencies() throws SQLException {
        return null;
    }

    @Override
    public Competency getCompetencyById(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        Competency competency = new Competency();
        String sql = "SELECT id,name from profit.competencies where id=" + id;
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            competency.setId(resultSet.getInt(1));
            competency.setName(resultSet.getString(2));
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
        return competency;
    }

    @Override
    public void update(Competency competency) {

    }

    @Override
    public void remove(Competency competency) {

    }

    @Override
    public void remove(Integer id) {

    }


    public LinkedList<Integer> getAllId() throws SQLException {
        PreparedStatement preparedStatement = null;
        LinkedList<Integer> idS = new LinkedList<>();
        String sql = "SELECT id from competencies";
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                idS.add(id);
            }

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
        return idS;
    }
}
