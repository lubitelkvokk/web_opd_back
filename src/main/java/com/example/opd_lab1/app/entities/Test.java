package com.example.opd_lab1.app.entities;

import lombok.Data;

@Data
public class Test {
    private Integer id;
    private Integer userId;
    private Integer testId;
    private Double time;
    private Double correctAnswers;

    public Test(int id, int userId, int testId, double time, double correctAnswer) {
        this.id = id;
        this.userId = userId;
        this.testId = testId;
        this.time = time;
        this.correctAnswers = correctAnswer;
    }
}
