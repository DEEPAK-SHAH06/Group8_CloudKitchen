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

    String sql = """
        SELECT ds.deliveryStaff_id,
               u.user_id,
               u.username,
               u.phone,
               ds.vehicle_type,
               ds.shift
        FROM delivery_staff ds
        JOIN users u ON ds.user_id = u.user_id
        WHERE u.role = 'DELIVERY'
        """;

    try (Connection con = mysql.openConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            DeliveryStaff d = new DeliveryStaff();
            d.setDeliveryStaff_id(rs.getInt("deliveryStaff_id"));
            d.setUser_id(rs.getInt("user_id"));
            d.setName(rs.getString("username"));
            d.setPhone(rs.getLong("phone"));
            d.setVehicleType(rs.getString("vehicle_type"));
            d.setShift(rs.getString("shift"));

            list.add(d);
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}

    public boolean deleteStaff(int deliveryStaffId) {

    String sql = "DELETE FROM delivery_staff WHERE deliveryStaff_id = ?";

    try (Connection con = mysql.openConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, deliveryStaffId);
        return ps.executeUpdate() > 0;

    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}

    public boolean addDeliveryStaff(int userId, String vehicleType, String shift) {
        String sql = """
            INSERT INTO delivery_staff (user_id, vehicle_type, shift)
            VALUES (?, ?, ?)
            """;

        try (Connection con = mysql.openConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setString(2, vehicleType);
            ps.setString(3, shift);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateDeliveryStaff(int deliveryStaffId, String vehicleType, String shift) {
    String sql = """
        UPDATE delivery_staff
        SET vehicle_type = ?, shift = ?
        WHERE deliveryStaff_id = ?
        """;

    try (Connection con = mysql.openConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, vehicleType);
        ps.setString(2, shift);
        ps.setInt(3, deliveryStaffId);

        return ps.executeUpdate() > 0;

    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
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

