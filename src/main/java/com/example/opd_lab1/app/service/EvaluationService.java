package com.example.opd_lab1.app.service;

import com.example.opd_lab1.app.entities.Evaluation;
import com.example.opd_lab1.app.dao.EvaluationDAO;
import com.example.opd_lab1.app.util.DbConnect;

import java.sql.*;

import java.sql.SQLException;
import java.util.LinkedList;

public class EvaluationService implements EvaluationDAO {

    Connection connection = new DbConnect().getConnection();

    @Override
    public void add(Evaluation evaluation) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO evaluation (expert_id, profession_id, competencies_id, raiting) VALUES (?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, evaluation.getExpertId());
            preparedStatement.setInt(2, evaluation.getProfessionId());
            preparedStatement.setInt(3, evaluation.getCompetency_id());
            preparedStatement.setDouble(4, evaluation.getRaiting());
            preparedStatement.executeUpdate();
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
    }

    @Override
    public LinkedList<Evaluation> getEvaluationsByProfessionId(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
        LinkedList<Evaluation> evaluations = new LinkedList<>();
        String sql = "SELECT id,expert_id, profession_id, competencies_id, raiting " +
                "from evaluation where profession_id=" + id;
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Evaluation evaluation = new Evaluation();
                evaluation.setId(resultSet.getInt(1));
                evaluation.setExpertId(resultSet.getInt(2));
                evaluation.setProfessionId(resultSet.getInt(3));
                evaluation.setCompetency_id(resultSet.getInt(4));
                evaluation.setRaiting(resultSet.getDouble(5));
                evaluations.add(evaluation);
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
        return evaluations;
    }

    @Override
    public void update(Evaluation evaluation) {

    }

    @Override
    public void remove(Evaluation evaluation) {

    }

    @Override
    public void remove(Integer id) {

    }



    public LinkedList<Evaluation> getAllEvaluations() throws SQLException {
        PreparedStatement preparedStatement = null;
        LinkedList<Evaluation> evaluations = new LinkedList<>();
        String sql = "SELECT expert_id, profession_id, competencies_id, raiting from evaluation";
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            Evaluation evaluation = new Evaluation();
            while (resultSet.next()) {
                evaluation.setExpertId(resultSet.getInt(1));
                evaluation.setProfessionId(resultSet.getInt(2));
                evaluation.setCompetency_id(resultSet.getInt(3));
                evaluation.setRaiting(resultSet.getDouble(4));
            }
            evaluations.add(evaluation);
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
        return evaluations;
    }
}
