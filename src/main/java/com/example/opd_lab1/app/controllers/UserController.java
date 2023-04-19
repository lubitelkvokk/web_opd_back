package com.example.opd_lab1.app.controllers;

import com.example.opd_lab1.app.entities.User;
import com.example.opd_lab1.app.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.LinkedList;

@RestController
public class UserController {


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllUsers")
    public LinkedList<User> getAllUsers() throws SQLException {
        UserService userService = new UserService();
        return userService.getAllUsers();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getUserById")
    public User getUserById(int id) throws SQLException {
        UserService userService = new UserService();
        return userService.getUserById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getUserByLogin")
    public User getUserByLogin(String login) throws SQLException {
        UserService userService = new UserService();
        return userService.getUserByLogin(login);
    }


}
