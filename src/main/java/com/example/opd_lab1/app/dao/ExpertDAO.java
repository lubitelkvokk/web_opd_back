package com.example.opd_lab1.app.dao;

import com.example.opd_lab1.app.entities.Evaluation;
import com.example.opd_lab1.app.entities.Expert;

import java.sql.SQLException;
import java.util.LinkedList;

public interface ExpertDAO {
    void add(Expert expert) throws SQLException;

    LinkedList<Expert> getAllExperts(int id) throws SQLException;

    Expert getExpertById(int id) throws SQLException;

    void update(Expert evaluation);

    void remove(Expert evaluation);

    void remove(Integer id);
}
