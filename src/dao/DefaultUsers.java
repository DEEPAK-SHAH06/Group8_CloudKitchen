/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.MySqlConnection;
import java.sql.*;

/**
 *
 * @author deepakshah
 */
public class DefaultUsers {

    public static void createDefaultAccounts() {
        MySqlConnection mysql = new MySqlConnection();
        Connection conn = mysql.openConnection();

        try {
            // admin
            String adminSQL = "INSERT IGNORE INTO users (username, email, password, role) VALUES ('admin', 'admin@gmail.com', 'admin123', 'ADMIN')";
            conn.prepareStatement(adminSQL).executeUpdate();

            // kitchen
            String kitchenSQL = "INSERT IGNORE INTO users (username, email, password, role) VALUES ('kitchen', 'kitchen@gmail.com', 'kitchen123', 'KITCHEN')";
            conn.prepareStatement(kitchenSQL).executeUpdate();

        } catch (SQLException e) {
            System.out.println("DEFAULT USER ERROR: " + e.getMessage());
        } finally {
            mysql.closeConnection(conn);
        }
    }
}

