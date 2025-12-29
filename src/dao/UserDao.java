/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.MySqlConnection;
import java.util.ArrayList;
import java.util.List;
import model.Users;
import java.sql.*;

/**
 *
 * @author deepakshah
 */
public class UserDao {

    MySqlConnection mysql = new MySqlConnection();

    public List<Users> getAllUsers() {
        List<Users> list = new ArrayList<>();
        String sql = "SELECT user_id, username, email, phone, role FROM users";

        try (Connection con = mysql.openConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Users u = new Users();
                u.setUser_id(rs.getInt("user_id"));
                u.setUsername(rs.getString("username"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getLong("phone"));
                u.setRole(rs.getString("role"));
                list.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean deleteUser(int userId) {
        String sql = "DELETE FROM users WHERE user_id = ?";

        try (Connection con = mysql.openConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addUser(Users user) {
        Connection conn = mysql.openConnection();
        String sql = "INSERT INTO users (username, email, password, role) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getEmail());
            pstm.setString(3, user.getPassword());
            pstm.setString(4, "CUSTOMER"); // automatically assign USER role

            pstm.executeUpdate();
            return true; // return true if user is added successfully

        } catch (SQLException e) {
            System.out.println("USER ADDITION ERROR: " + e.getMessage());
            return false;
        } finally {
            mysql.closeConnection(conn);
        }
    }

    public boolean updateUser(Users user) {
        Connection conn = mysql.openConnection();
        String sql = "UPDATE users SET username = ?, email = ?, password = ?, phone = ?, role = ? WHERE user_id = ?";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getEmail());
            pstm.setString(3, user.getPassword());
            pstm.setLong(4, user.getPhone());
            pstm.setString(5, user.getRole());
            pstm.setInt(6, user.getUser_id()); // set the user_id for the WHERE clause

            return pstm.executeUpdate() > 0; // return true if user is updated successfully

        } catch (SQLException e) {
            System.out.println("USER UPDATE ERROR: " + e.getMessage());
            return false;
        } finally {
            mysql.closeConnection(conn);
        }
    }

    public int addUserAndReturnId(Users u) {
        String sql = """
                INSERT INTO users (username, email, password, phone, role)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection con = mysql.openConnection();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, u.getUsername());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setLong(4, u.getPhone());
            ps.setString(5, u.getRole());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // user_id
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void updatePhone(int userId, long phone) {
        String sql = "UPDATE users SET phone = ? WHERE user_id = ?";

        try (Connection con = mysql.openConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setLong(1, phone);
            ps.setInt(2, userId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
