/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author deepakshah
 */
import database.MySqlConnection;
import java.sql.*;
import java.util.*;
import model.Users;

public class AdminDao {

    private MySqlConnection mysql = new MySqlConnection();

    // Fetch all users
    public List<Users> getAllUsers() {

        List<Users> list = new ArrayList<>();
        Connection conn = mysql.openConnection();

        String sql = """
            SELECT user_id, username, email, phone, role
            FROM users
            WHERE role != 'ADMIN'
        """;

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Users u = new Users();
                u.setUser_id(rs.getInt("user_id"));
                u.setUsername(rs.getString("username"));
                u.setEmail(rs.getString("email"));
                //u.setPhone(rs.getLong("phone"));
                u.setRole(rs.getString("role"));
                list.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysql.closeConnection(conn);
        }

        return list;
    }

    // Add user
    public boolean addUser(Users u) {

        Connection conn = mysql.openConnection();
        String sql = """
            INSERT INTO users (username, email, phone, role)
            VALUES (?,?,?,?)
        """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getEmail());
            //ps.setLong(3, u.getPhone());
            ps.setString(4, u.getRole());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }

    // Update user
    public boolean updateUser(Users u) {

        Connection conn = mysql.openConnection();
        String sql = """
            UPDATE users
            SET username=?, email=?, phone=?, role=?
            WHERE user_id=?
        """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getEmail());
            //ps.setLong(3, u.getPhone());
            ps.setString(4, u.getRole());
            ps.setInt(5, u.getUser_id());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }

    // Delete user
    public boolean deleteUser(int userId) {

        Connection conn = mysql.openConnection();
        String sql = "DELETE FROM users WHERE user_id=?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysql.closeConnection(conn);
        }
        return false;
    }
}

