package com.example.opd_lab1.app;

import lombok.Data;

import java.util.List;

@Data
public class Evaluation {

    private List<Competency> competencies;
    private Expert expert;
    private Double raiting;


    public Evaluation(Expert expert, List<Competency> competencies) {
        this.expert = expert;
        this.competencies = competencies;
    }
}
