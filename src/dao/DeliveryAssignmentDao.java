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
public class DeliveryAssignmentDao {
    MySqlConnection mysql = new MySqlConnection();

    public void assignOrderToDelivery(int orderId, int deliveryStaffId) {

        String sql = """
                    INSERT INTO delivery_assignments
                    (order_id, deliveryStaff_id, assigned_time)
                    VALUES (?, ?, NOW())
                """;

        try (Connection con = mysql.openConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, orderId);
            ps.setInt(2, deliveryStaffId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateOrderStatus(int orderId) {
        String sql = "UPDATE orders SET order_status='ASSIGNED_FOR_DELIVERY' WHERE order_id=?";

        try (Connection con = mysql.openConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, orderId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
