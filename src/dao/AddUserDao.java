/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import database.MySqlConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Users;

/**
 *
 * @author Limbu Mbg Sujata
 */
public class AddUserDao {
    
    // Method to add a user to the database
    public boolean Adduser(Users user) {
        MySqlConnection mysqlConnection = new MySqlConnection();
        Connection conn = mysqlConnection.openConnection();
        
        String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        
        try (
                
             PreparedStatement pst = conn.prepareStatement(query)) {
            
            // Setting the values from the AddUser object
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getPassword());
            
            int result = pst.executeUpdate();
            
            // Returns true if at least one row was inserted
            return result > 0;
            
        } catch (SQLException e) {
            System.out.println("Error adding user: " + e.getMessage());
            return false;
        }
    }
}
