/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.MySqlConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Users;

/**
 *
 * @author deepakshah
 */
public class SignUpDao {

    MySqlConnection mysql = new MySqlConnection();
    
//    public int signUp(Users user) {
//
//    Connection conn = mysql.openConnection();
//    String sql = "INSERT INTO users (username, email, password, role) VALUES (?, ?, ?, ?)";
//
//    try (PreparedStatement pstm =
//         conn.prepareStatement(sql)) {
//
//        pstm.setString(1, user.getUsername());
//        pstm.setString(2, user.getEmail());
//        pstm.setString(3, user.getPassword());
//        pstm.setString(4, "CUSTOMER");
//
//        pstm.executeUpdate();
//
//        ResultSet rs = pstm.getGeneratedKeys();
//        if (rs.next()) {
//            return rs.getInt(1);
//        }
//
//    } catch (SQLException e) {
//        throw new RuntimeException(e);
//    } finally {
//        mysql.closeConnection(conn);
//    }
//    return -1;
//}

    public void signUp(Users user) {
    Connection conn = mysql.openConnection();
    String sql = "INSERT INTO users (username, email, password, role) VALUES (?, ?, ?, ?)";
    
    try (PreparedStatement pstm =
         conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        pstm.setString(1, user.getUsername());
        pstm.setString(2, user.getEmail());
        pstm.setString(3, user.getPassword());
        pstm.setString(4, "CUSTOMER");

        pstm.executeUpdate();

        //  GET GENERATED USER_ID
        ResultSet rs = pstm.getGeneratedKeys();
        if (rs.next()) {
            user.setUser_id(rs.getInt(1));
        }

    } catch (SQLException e) {
        throw new RuntimeException(e);
    } finally {
        mysql.closeConnection(conn);
    }
}

    public boolean checkExists(Users user) {

        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM users WHERE username=? OR email=?";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getEmail());
            ResultSet result = pstm.executeQuery();

            return result.next();

        } catch (SQLException e) {
            System.out.println("CHECK EXISTS ERROR: " + e.getMessage());
        } finally {
            mysql.closeConnection(conn);
        }

        return false;
    }
}
