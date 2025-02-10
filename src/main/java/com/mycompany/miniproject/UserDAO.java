package com.mycompany.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public static boolean insertUser(User user) {
        String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            System.out.println("[INFO] Inserting User - Username: " + user.getUsername());

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());

            int rowsInserted = stmt.executeUpdate();
            System.out.println("[INFO] Rows Inserted: " + rowsInserted);

            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("[ERROR] Failed to insert user: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static boolean checkIfUserExists(String username, String email) {
        String query = "SELECT * FROM users WHERE username = ? OR email = ?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, email);
            ResultSet rs = stmt.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            System.out.println("[ERROR] Failed to check user existence: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    public static boolean validateUser(String username, String password) {
    String query = "SELECT * FROM users WHERE username = ? AND password = ?";
    try (Connection conn = DBConnect.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();

        return rs.next(); // If a record is found, login is successful
    } catch (SQLException e) {
        System.out.println("[ERROR] Failed to validate user: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
}
    public static String getEmailByUsername(String username) {
    String email = null;
    String query = "SELECT email FROM users WHERE username = ?";
    
    try (Connection conn = DBConnect.getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            email = rs.getString("email");
        }
    } catch (SQLException e) {
        System.out.println("[ERROR] Failed to fetch email: " + e.getMessage());
        e.printStackTrace();
    }

    return email;
}


}
