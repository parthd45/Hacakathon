/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.miniproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author parth
 */
public class DBConnect {
    private static final String URL = "jdbc:mysql://localhost:3306/msg";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("[INFO] Database connected successfully!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("[ERROR] Database connection failed: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }
}
