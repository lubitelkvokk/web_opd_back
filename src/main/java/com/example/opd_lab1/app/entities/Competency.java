package com.example.opd_lab1.app.entities;

import lombok.Data;

@Data
public class Competency {

    private Integer id;

    private String name;

    private Double raiting;

    public Competency(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Competency(int id, String name, double raiting) {
        this.id = id;
        this.name = name;
        this.raiting = raiting;
    }

    public Competency() {

    }
//    public Competency(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }
}
