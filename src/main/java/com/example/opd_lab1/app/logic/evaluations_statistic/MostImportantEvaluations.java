package com.example.opd_lab1.app.logic.evaluations_statistic;

import com.example.opd_lab1.app.entities.Evaluation;
import com.example.opd_lab1.app.entities.Expert;
import com.example.opd_lab1.app.service.CompetenciesService;
import com.example.opd_lab1.app.service.EvaluationService;
import com.example.opd_lab1.app.service.ExpertService;

import java.sql.SQLException;
import java.util.*;

public class MostImportantEvaluations {


    public LinkedList<PvkWithRaitings> handleEvaluations(LinkedList<Evaluation> evaluations) throws SQLException {
        LinkedList<Evaluation> result = new LinkedList<>();
        EvaluationService evaluationService = new EvaluationService();

        HashMap<Integer, LinkedList<Double>> pvks = new HashMap<>();
        for (Evaluation evaluation : evaluations) {
            Integer expert_id = evaluation.getExpertId();
            ExpertService expertService = new ExpertService();
            Expert expert = expertService.getExpertById(expert_id);
            // Получили рейтинг эксперта
            Double expertRelevance = expert.getRelevance();

            LinkedList<Double> tempList = pvks.get(evaluation.getCompetency_id());
            if (tempList == null) {
                tempList = new LinkedList<>();
            }
            tempList.add(expertRelevance * evaluation.getRaiting());
            System.out.println(expert_id + ":" + expertRelevance + ":" + evaluation.getRaiting());
            pvks.put(evaluation.getCompetency_id(), tempList);
        }

        CompetenciesService competenciesService = new CompetenciesService();

        LinkedList<PvkWithRaitings> pvkWithRaitings = new LinkedList<>();
        for (int i : competenciesService.getAllId()) {
            LinkedList<Double> raitings = pvks.get(i);
            if (raitings != null) {
                Double average = OperationWithList.getAverageValue(raitings);
                pvkWithRaitings.add(new PvkWithRaitings(i, average));
            }
        }
        pvkWithRaitings.sort((o1, o2) -> o2.compareTo(o1));
        for (PvkWithRaitings x: pvkWithRaitings){
            System.out.println(x.getRaiting());
        }
        return pvkWithRaitings;
    }
}
