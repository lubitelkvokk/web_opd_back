package com.example.opd_lab1.app.logic.evaluations_statistic;

import java.util.LinkedList;

public class OperationWithList {


    public static Double getAverageValue(LinkedList<Double> list) {
        Double sum = 0.0;
        Integer len = 0;
        for (Double d : list) {
            len++;
            sum += d;
        }
        return Math.floor(sum / len);
    }
}
