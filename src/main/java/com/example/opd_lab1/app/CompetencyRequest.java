package com.example.opd_lab1.app;

import com.example.opd_lab1.app.entities.Competency;

import java.util.ArrayList;

public class CompetencyRequest {
    private Integer professionId;
    private String expertId;
    private ArrayList<Competency> competencies;

    public CompetencyRequest(String expertId, Integer professionId, ArrayList<Competency> competencies) {
        this.professionId = professionId;
        this.expertId = expertId;
        this.competencies = competencies;
    }

    public ArrayList<Competency> getCompetencies() {
        return competencies;
    }

    public String getExpertId() {
        return expertId;
    }

    public Integer getProfessionId() {
        return professionId;
    }

    public void setCompetencies(String expertId,Integer professionId,  ArrayList<Competency> competencies) {
        this.professionId = professionId;
        this.expertId = expertId;
        this.competencies = competencies;
    }
}
