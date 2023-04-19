package com.example.opd_lab1.app.entities;



public class Proffesion {
    private String id;
    private String name;
    private String description;
    public Proffesion(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Proffesion() {
        
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
