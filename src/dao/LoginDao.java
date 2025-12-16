/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Users;

/**
 *
 * @author deepakshah
 */
public class LoginDao {

    MySqlConnection mysql = new MySqlConnection();

    public boolean login(Users user, String selectedRole) {

        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM users WHERE email = ? AND password = ? AND role = ?";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, user.getEmail());
            pstm.setString(2, user.getPassword());
            pstm.setString(3, selectedRole);

            ResultSet result = pstm.executeQuery();
            return result.next();

        } catch (SQLException e) {
            System.out.println("LOGIN ERROR: " + e.getMessage());
        } finally {
            mysql.closeConnection(conn);
        }

        return false;
    }
    
    
    
    public boolean updatePassword(String email, String newPassword) {
        
        Connection con = mysql.openConnection();
    
        String sql = "UPDATE users SET password=? WHERE email=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, newPassword);
            ps.setString(2, email);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
    }
}

    
}

