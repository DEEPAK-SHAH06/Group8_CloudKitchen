/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.MySqlConnection;
import java.sql.*;
import model.Users;
import utils.UserSession;

/**
 *
 * @author deepakshah
 */
public class CustomerDao {

    MySqlConnection mysql = new MySqlConnection();

    // Returns customer_id
    public int getOrCreateCustomer(int userId, String address) {
        String selectSql = "SELECT customer_id FROM customers WHERE user_id = ?";
        String insertSql = "INSERT INTO customers (user_id, address) VALUES (?, ?)";
        String updateSql = "UPDATE customers SET address = ? WHERE user_id = ?";

        try (Connection con = mysql.openConnection()) {

            Users user = UserSession.getCurrentUser();

            if (user == null || user.getUser_id() <= 0) {
                throw new IllegalStateException("Invalid user session");
            }

            // Check if customer already exists
            PreparedStatement ps = con.prepareStatement(selectSql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Update address
                PreparedStatement ups = con.prepareStatement(updateSql);
                ups.setString(1, address);
                ups.setInt(2, userId);
                ups.executeUpdate();

                return rs.getInt("customer_id");
            }

            // Insert new customer
            PreparedStatement ips = con.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
            ips.setInt(1, userId);
            ips.setString(2, address);
            ips.executeUpdate();

            ResultSet keys = ips.getGeneratedKeys();
            if (keys.next()) {
                return keys.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }
}
