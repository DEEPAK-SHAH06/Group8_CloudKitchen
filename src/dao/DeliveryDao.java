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
import model.DeliveryStaff;
import java.sql.*;
import java.util.*;
import model.DeliveryOrder;

public class DeliveryDao {
    
    MySqlConnection mysql= new MySqlConnection();
    
    // This method is for manageDelivery Table of Admin Dashboard;

    public List<DeliveryStaff> getAllStaff() {
        List<DeliveryStaff> list = new ArrayList<>();
        String sql = "SELECT * FROM delivery_staff";

        try (Connection con = mysql.openConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

//            while (rs.next()) {
//                DeliveryStaff d = new DeliveryStaff();
//                d.setDeliveryStaff_id(rs.getInt("staff_id"));
//                d.setDeliveryStaff_name(rs.getString("name"));
//                d.setDeliveryStaff_email(rs.getString("phone")); // replce with phone
//                d.setDeliveryStaff_password(rs.getString("vehicle_type")); // replace with vehicle type
//                d.setShift(rs.getString("status")); // replace with status
//                list.add(d);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    // The below methods are for DeliveryDashboard;
    
    public List<DeliveryOrder> getDeliveryOrders() {

        List<DeliveryOrder> list = new ArrayList<>();

        String sql = """
            SELECT o.order_id,
                   u.username,
                   c.address,
                   u.phone,
                   o.order_time,
                   o.order_status
            FROM orders o
            JOIN customers c ON o.customer_id = c.customer_id
            JOIN users u ON c.user_id = u.user_id
            WHERE o.order_status IN ('CONFIRMED','PREPARING','OUT_FOR_DELIVERY')
            """;

        try (Connection con = mysql.openConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new DeliveryOrder(
                        rs.getInt("order_id"),
                        rs.getString("username"),
                        rs.getString("address"),
                        rs.getLong("phone"),
                        rs.getTimestamp("order_time").toLocalDateTime(),
                        rs.getString("order_status")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateOrderStatus(int orderId, String status) {
        String sql = "UPDATE orders SET order_status=? WHERE order_id=?";

        try (Connection con = mysql.openConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, orderId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

