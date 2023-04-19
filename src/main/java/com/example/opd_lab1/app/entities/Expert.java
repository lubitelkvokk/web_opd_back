package com.example.opd_lab1.app.entities;

import lombok.Data;

@Data
public class Expert {
    private Integer id;
    private String identifier;
    private String fio;
    private Double relevance;

    public Expert(int expert_id, String fio, double relevance) {
        this.id = expert_id;
        this.fio = fio;
        this.relevance = relevance;
    }

    public Expert() {

    }
}
