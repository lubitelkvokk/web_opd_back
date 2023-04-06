package com.example.opd_lab1.app;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class DbConnect {

    private String username = "name";
    private String password = "password";
    private String url = "jdbc:mysql://localhost:3306/profit";

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUrl() {
        return url;
    }

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    public static Connection getConnection() throws SQLException, ClassNotFoundException {

            // opening database connection to MySQL server
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/profit", "name_of_database", "password");

            // getting Statement object to execute query
            stmt = con.createStatement();

        return con;
    }


}


