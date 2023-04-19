package com.example.opd_lab1.app.dao;

import com.example.opd_lab1.app.entities.Competency;
import com.example.opd_lab1.app.entities.Evaluation;

import java.sql.SQLException;
import java.util.LinkedList;

public interface CompetenciesDAO {
    void add(Competency competency) throws SQLException;

    LinkedList<Competency> getAllCompetencies() throws SQLException;


    Competency getCompetencyById(int id) throws SQLException;

//    LinkedList<Competency> getCompetenciesBy
    void update(Competency competency);

    void remove(Competency competency);

    void remove(Integer id);
}
