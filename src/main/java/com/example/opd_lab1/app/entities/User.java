package com.example.opd_lab1.app.entities;

import lombok.Data;

@Data
public class User {

    private Integer id;
    private String login;

    private String password;

    private String status;


    public User(int id, String login, String password, String status) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.status = status;
    }

    public User() {
        
    }
}
