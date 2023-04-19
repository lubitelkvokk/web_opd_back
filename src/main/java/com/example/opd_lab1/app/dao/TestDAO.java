package com.example.opd_lab1.app.dao;

import com.example.opd_lab1.app.entities.Test;

import java.sql.SQLException;
import java.util.LinkedList;

public interface TestDAO {

    LinkedList<Test> getAllResults();

    LinkedList<Test> getResultsByUserId(Integer userId) throws SQLException;

    LinkedList<Test> getResultsByTestId(Integer testId);

    LinkedList<Test> getResultsByUserIdAndTestId(Integer userId, Integer testId) throws SQLException;
}
