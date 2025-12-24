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
    
    private MySqlConnection mysql;

    public List<Order> getAllOrders() {
        List<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM orders";

        try (Connection con = mysql.openConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Order o = new Order();
                o.setOrder_id(rs.getInt("order_id"));
//                o.setCustomer_id(rs.getInt("customer_id"));
//                o.setTotalAmount(rs.getDouble("total_amount"));
//                o.setOrderTime(rs.getTimestamp("order_time").toLocalDateTime());
//                o.setOrderStatus(rs.getString("status"));
//                list.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

