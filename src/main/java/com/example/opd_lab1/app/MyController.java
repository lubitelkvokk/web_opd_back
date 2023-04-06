package com.example.opd_lab1.app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
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
        Connection con = DbConnect.getConnection();
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
    @GetMapping("/getEvaluationsByProfessionId")
    public List<Evaluation> getEvaluationsByProfessionId(int id) throws SQLException, ClassNotFoundException {

        List<Evaluation> records = new ArrayList<>();
        List<Expert> experts = new ArrayList<>();

        try (Connection con = DbConnect.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM experts")) {

            while (rs.next()) {
                int expertId = rs.getInt(1);
                String fio = rs.getString(3);
                double expertRelevance = rs.getDouble(4);
                experts.add(new Expert(expertId, fio, expertRelevance));
            }
        }

        try (Connection con = DbConnect.getConnection();
             Statement stmt = con.createStatement()) {

            for (Expert expert : experts) {
                ResultSet evaluations = stmt.executeQuery("SELECT evaluation.*, competencies.name " +
                        "FROM evaluation " +
                        "JOIN competencies ON evaluation.competencies_id = competencies.id " +
                        "WHERE evaluation.profession_id =" + id + " AND evaluation.expert_id=" + expert.getId());

                List<Competency> competencies = new ArrayList<>();
                String competencyName = "";
                while (evaluations.next()) {
                    int competencyId = evaluations.getInt(4);
                    double rating = evaluations.getDouble(5);
                    competencyName = evaluations.getString(6);
                    Competency competency = new Competency(competencyId, competencyName, rating);
                    competencies.add(competency);

                }
                if (!competencies.isEmpty()) {
                    Evaluation evaluation = new Evaluation(expert, competencies);
                    records.add(evaluation);
                }
            }
        }

        return records;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getDataAboutExpert")
    public boolean getDataAboutExpert(String expertId) throws SQLException, ClassNotFoundException {

        Connection con = DbConnect.getConnection();
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
        Connection con = DbConnect.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from experts where identifier='" + expertId + "'");
        rs.next();
        int key = rs.getInt(1);
        return key;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllCompetencies")
    public ArrayList<Competency> getSimpleExpertId() throws SQLException, ClassNotFoundException {
        Connection con = DbConnect.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from competencies");
        ArrayList<Competency> competencies = new ArrayList<>();
        while (rs.next()) {
            int ind = rs.getInt(1);
            String name = rs.getString(2);
            competencies.add(new Competency(ind, name));
        }
        return competencies;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/api/your-end-point")
    public ResponseEntity<Object> yourMethod(@RequestBody int yourInteger) {
        System.out.println(yourInteger);
        return ResponseEntity.ok().build();
    }
}




