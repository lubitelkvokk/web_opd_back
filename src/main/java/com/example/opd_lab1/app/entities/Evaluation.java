package com.example.opd_lab1.app.entities;

import lombok.Data;

import java.util.List;

@Data
public class Evaluation {


    private Integer id;
    private Integer competency_id;

    private Integer professionId;
    private Integer expertId;
    private Double raiting;


    public Evaluation(Integer expert, Integer competency, Integer professionId, Double raiting) {
        this.expertId = expert;
        this.professionId = professionId;
        this.competency_id = competency;
        this.raiting = raiting;
    }

    public Evaluation() {

    }
}
