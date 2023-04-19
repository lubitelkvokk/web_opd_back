package com.example.opd_lab1.app.logic.evaluations_statistic;

import com.example.opd_lab1.app.service.CompetenciesService;
import lombok.Data;

import java.sql.SQLException;

@Data
public class PvkWithRaitings implements Comparable<PvkWithRaitings> {

    private Integer id;
    private Double raiting;

    private String name;
    public PvkWithRaitings(Integer id, Double raiting) throws SQLException {
        this.id = id;
        this.raiting = raiting;
        CompetenciesService competenciesService = new CompetenciesService();
        this.name = competenciesService.getCompetencyById(id).getName();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getRaiting() {
        return raiting;
    }

    public void setRaitings(Double raiting) {
        this.raiting = raiting;
    }

    @Override
    public int compareTo(PvkWithRaitings o)
    {
        if (this.getRaiting() != o.getRaiting()) {
            return (int) (this.getRaiting() - o.getRaiting());
        }
        return this.raiting.compareTo(o.raiting);
    }
}

