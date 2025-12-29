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
import utils.PasswordUtil;

/**
 *
 * @author deepakshah
 */
public class LoginDao {

    MySqlConnection mysql = new MySqlConnection();

    public Users login(String email, String password, String role) {

        Connection conn = mysql.openConnection();
        String sql = "SELECT user_id, username, role FROM users WHERE email=? AND password=? AND role=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, PasswordUtil.hashPassword(password)); // hash ONCE
            ps.setString(3, role);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Users user = new Users();
                user.setUser_id(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(email);
                user.setRole(rs.getString("role"));
                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysql.closeConnection(conn);
        }
        return null;
    }

    public boolean updatePassword(String email, String newPassword) {

        Connection con = mysql.openConnection();
        String sql = "UPDATE users SET password=? WHERE email=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            String hashed = PasswordUtil.hashPassword(newPassword);
            ps.setString(1, hashed);
            ps.setString(2, email);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean emailExists(String email) {
        String sql = "SELECT 1 FROM users WHERE email=?";
        try (Connection con = mysql.openConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);
            return ps.executeQuery().next();

        } catch (Exception e) {
            return false;
        }
    }

}
