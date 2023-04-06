package com.example.opd_lab1.app;

import lombok.Data;

@Data
public class Competency {

    private int id;

    private String name;

    private double raiting;

    public Competency(int id, String name, double raiting) {
        this.id = id;
        this.name = name;
        this.raiting = raiting;
    }
    public Competency(int id, String name) {
        this.id = id;
        this.name = name;

    }
}
