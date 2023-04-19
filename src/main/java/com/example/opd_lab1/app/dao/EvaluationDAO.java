package com.example.opd_lab1.app.dao;


import com.example.opd_lab1.app.entities.Evaluation;

import java.sql.SQLException;
import java.util.LinkedList;

public interface EvaluationDAO {
    void add(Evaluation evaluation) throws SQLException;

    LinkedList<Evaluation> getEvaluationsByProfessionId(int id) throws SQLException;

    void update(Evaluation evaluation);

    void remove(Evaluation evaluation);

    void remove(Integer id);

}
