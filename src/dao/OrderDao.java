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
import model.Order;
import java.sql.*;
import java.util.*;

public class OrderDao {
    
    MySqlConnection mysql = new MySqlConnection();

    public List<Order> getAllOrders() {
    List<Order> list = new ArrayList<>();
    String sql = "SELECT * FROM orders";

    try (Connection con = mysql.openConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Order o = new Order();
            o.setOrder_id(rs.getInt("order_id"));
            o.setCustomer_id(rs.getInt("customer_id"));
            o.setTotalAmount(rs.getDouble("total_amount"));
            o.setOrderTime(rs.getTimestamp("order_time").toLocalDateTime());

            String status = rs.getString("order_status");
            o.setOrderStatus(Order.OrderStatus.valueOf(status));

            list.add(o);
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

    public void insertIntoKitchen(int orderId) {
    String sql = """
        INSERT INTO kitchen (order_id, item_id, cooking_status, order_time)
        SELECT o.order_id, k.item_id, 'PREPARING', NOW()
        FROM orders o
        JOIN kitchen k ON o.order_id = k.order_id
        WHERE o.order_id = ?
    """;

    try (Connection con = mysql.openConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, orderId);
        ps.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void deleteOrder(int orderId) {
    String sql = "DELETE FROM orders WHERE order_id=?";

    try (Connection con = mysql.openConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, orderId);
        ps.executeUpdate();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    
    // For Cart
    
    public int createOrder(int customerId, double total) {
        String sql = """
            INSERT INTO orders (customer_id, total_amount, order_time, order_status)
            VALUES (?, ?, NOW(), 'PENDING')
        """;

        try (Connection con = mysql.openConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, customerId);
            ps.setDouble(2, total);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }


}

