package com.example.opd_lab1.app;

import lombok.Data;

@Data
public class Expert {
    private int id;
    private String identifier;
    private String fio;
    private double relevance;

    public Expert(int expert_id, String fio, double relevance) {
        this.id = expert_id;
        this.fio = fio;
        this.relevance = relevance;
    }
}
