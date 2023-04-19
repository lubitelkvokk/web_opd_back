package com.example.opd_lab1.app.controllers;

import com.example.opd_lab1.app.entities.Test;
import com.example.opd_lab1.app.service.TestService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.LinkedList;

@RestController
public class TestController {

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllTest")
    public LinkedList<Test> getAllTest() throws SQLException {
        TestService testService = new TestService();
        return testService.getAllResults();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getResultsByUserId")
    public LinkedList<Test> getResultsByUserId(Integer userId) throws SQLException {
        TestService testService = new TestService();
        return testService.getResultsByUserId(userId);
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getResultsByUserIdAndTestId")
    public LinkedList<Test> getResultsByUserIdAndTestId(Integer userId,
                                                        Integer testId) {
        TestService testService = new TestService();
        return testService.getResultsByUserIdAndTestId(userId, testId);
    }
}
