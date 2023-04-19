package com.example.opd_lab1.app.controllers;

import com.example.opd_lab1.app.CompetencyRequest;
import com.example.opd_lab1.app.entities.Competency;
import com.example.opd_lab1.app.entities.Evaluation;
import com.example.opd_lab1.app.entities.Proffesion;
import com.example.opd_lab1.app.logic.evaluations_statistic.MostImportantEvaluations;
import com.example.opd_lab1.app.logic.evaluations_statistic.PvkWithRaitings;
import com.example.opd_lab1.app.service.CompetenciesService;
import com.example.opd_lab1.app.service.EvaluationService;
import com.example.opd_lab1.app.util.DbConnect;
import org.json.*;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
public class MyController {

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get")
    public Proffesion getName() {
        return new Proffesion("HJoTogo*&^786909t&HKhiuogore34", "Frontend-разработчик",
                "Верстка сайта");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getProfs")
    public List<Proffesion> getProffesions() throws SQLException, ClassNotFoundException {
        Connection con = new DbConnect().getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from professions");
        List<Proffesion> records = new ArrayList<>();
        while (rs.next()) {
            Proffesion proffesion = new Proffesion(rs.getString(1),
                    rs.getString(2),
                    rs.getString(3));
            records.add(proffesion);
        }
        return records;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getEvaluationsByProfessionsId")
    public LinkedList<PvkWithRaitings> getEvaluationsByProfessionId(int id) throws SQLException, ClassNotFoundException {
        EvaluationService evaluationService = new EvaluationService();
        LinkedList<Evaluation> evaluations = evaluationService.getEvaluationsByProfessionId(id);
//        return evaluations;

        MostImportantEvaluations mostImportantEvaluations = new MostImportantEvaluations();
        LinkedList<PvkWithRaitings> pvks = mostImportantEvaluations.handleEvaluations(evaluations);

        return pvks;
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getCompetencyById")
    public Competency getCompetencyById(int id) throws SQLException, ClassNotFoundException {
        CompetenciesService competenciesService = new CompetenciesService();
        return competenciesService.getCompetencyById(id);
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getDataAboutExpert")
    public boolean getDataAboutExpert(String expertId) throws SQLException, ClassNotFoundException {

        Connection con = new DbConnect().getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from experts");
        while (rs.next()) {
            String key = rs.getString(2);
            if (key.equals(expertId)) {
                return true;
            }
        }
        return false;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getSimpleExpertId")
    public int getSimpleExpertId(String expertId) throws SQLException, ClassNotFoundException {
        Connection con = new DbConnect().getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from experts where identifier='" + expertId + "'");
        rs.next();
        int key = rs.getInt(1);
        return key;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllCompetencies")
    public ArrayList<Competency> getAllCompetencies() throws SQLException, ClassNotFoundException {
        Connection con = new DbConnect().getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from competencies");
        ArrayList<Competency> competencies = new ArrayList<>();
        while (rs.next()) {
            int ind = rs.getInt(1);
            String name = rs.getString(2);
            competencies.add(new Competency(ind, name, 0));
        }

        return competencies;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/put_evaluations")
    public String putId(@RequestBody String str) throws SQLException, ClassNotFoundException, ParseException {

        CompetencyRequest competencyRequest = getCompetencyRequestFromString(str);

        Connection con = new DbConnect().getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from experts where identifier='"
                + competencyRequest.getExpertId() + "'");
        rs.next();
        int key = rs.getInt(1);

        Statement stmt1 = con.createStatement();
        for (Competency competency : competencyRequest.getCompetencies()) {
//            System.out.println("(id,expert_id, profession_id, competencies_id, raiting) values(7," + key + "," +
//                    competencyRequest.getProfessionId() + "," + competency.getId() +
//                    "," + competency.getRaiting() + ");");
            stmt1.executeUpdate("insert into evaluation " +
                    "(expert_id, profession_id, competencies_id, raiting) values(" + key + "," +
                    competencyRequest.getProfessionId() + "," + competency.getId() +
                    ","+ competency.getRaiting() + ");");


        }

        return "ПОСОСИ";
    }


    public CompetencyRequest getCompetencyRequestFromString(String jsonString) throws ParseException {
        JSONObject obj = new JSONObject(jsonString);

        String expertId = obj.getString("expertId");
        Integer professionId = obj.getInt("professionId");
        JSONArray competencies = obj.getJSONArray("competencies");
        ArrayList<Competency> temp = new ArrayList<Competency>();
        for (int i = 0; i < competencies.length(); i++) {
            if (!competencies.getJSONObject(i).getString("name").contains("ПВК")) {
                temp.add(new Competency(
                        competencies.getJSONObject(i).getInt("id"),
                        competencies.getJSONObject(i).getString("name"),
                        competencies.getJSONObject(i).getDouble("raiting")));
            }

        }
        return new CompetencyRequest(expertId, professionId, temp);
    }


}




