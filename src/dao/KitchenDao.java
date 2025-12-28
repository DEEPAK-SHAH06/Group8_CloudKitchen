/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author deepakshah
 */
import model.*;
import database.MySqlConnection;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class KitchenDao {

    MySqlConnection mysql = new MySqlConnection();
    
    

    // Fetch orders for kitchen dashboard
//    public List<Kitchen> getKitchenOrders() {
//
//        List<Kitchen> list = new ArrayList<>();
//        Connection conn = mysql.openConnection();
//
//        String sql = """
//            SELECT o.order_id, o.order_status, o.order_time,
//                   c.customer_id, c.username,
//                   i.item_id, i.item_name
//            FROM orders o
//            JOIN customers c ON o.customer_id = c.customer_id
//            JOIN order_items oi ON o.order_id = oi.order_id
//            JOIN items i ON oi.item_id = i.item_id
//            WHERE o.order_status IN ('PENDING','PREPARING')
//            ORDER BY o.order_time ASC
//        """;
//
//        try (PreparedStatement ps = conn.prepareStatement(sql);
//             ResultSet rs = ps.executeQuery()) {
//
//            while (rs.next()) {
//
//                Order order = new Order();
//                order.setOrder_id(rs.getInt("order_id"));
//                order.setOrderStatus(
//                        Order.OrderStatus.valueOf(rs.getString("order_status"))
//                );
//
//                Customers customer = new Customers();
//                customer.setCustomer_id(rs.getInt("customer_id"));
//                customer.setUsername(rs.getString("username"));
//
//                Item item = new Item();
//                item.setItem_id(rs.getInt("item_id"));
//                item.setItemName(rs.getString("item_name"));
//
//                Kitchen kitchen = new Kitchen(
//                        order,
//                        customer,
//                        item,
//                        Kitchen.CookingStatus.PREPARING,
//                        rs.getTimestamp("order_time").toLocalDateTime()
//                );
//
//                list.add(kitchen);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            mysql.closeConnection(conn);
//        }
//
//        return list;
//    }

    // Update order status (Start Cooking / Ready)
//    public boolean updateOrderStatus(int orderId, String status) {
//
//        Connection conn = mysql.openConnection();
//        String sql = "UPDATE orders SET order_status = ? WHERE order_id = ?";
//
//        try (PreparedStatement ps = conn.prepareStatement(sql)) {
//
//            ps.setString(1, status);
//            ps.setInt(2, orderId);
//
//            return ps.executeUpdate() > 0;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            mysql.closeConnection(conn);
//        }
//
//        return false;
//    }
//    
//    
    
    
    public List<KitchenOrder> getKitchenOrders() {

        List<KitchenOrder> list = new ArrayList<>();

        String sql = """
            SELECT k.kitchen_id, o.order_id, u.username, i.item_name,
                   k.cooking_status, k.order_time
            FROM kitchen k
            JOIN orders o ON k.order_id = o.order_id
            JOIN customers c ON o.customer_id = c.customer_id
            JOIN users u ON c.user_id = u.user_id
            JOIN items i ON k.item_id = i.item_id
            ORDER BY k.order_time DESC
        """;

        try (Connection con = mysql.openConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new KitchenOrder(
                        rs.getInt("kitchen_id"),
                        rs.getInt("order_id"),
                        rs.getString("username"),
                        rs.getString("item_name"),
                        rs.getString("cooking_status"),
                        rs.getTimestamp("order_time").toLocalDateTime()
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 🔄 Update cooking status
    public void updateCookingStatus(int kitchenId, String status) {

        String sql = "UPDATE kitchen SET cooking_status=? WHERE kitchen_id=?";

        try (Connection con = mysql.openConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, kitchenId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    // For Cart : 
    
    
    public void addKitchenItem(int orderId, int itemId) {
        String sql = """
            INSERT INTO kitchen (order_id, item_id, cooking_status, order_time)
            VALUES (?, ?, 'PREPARING', NOW())
        """;

        try (Connection con = mysql.openConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, orderId);
            ps.setInt(2, itemId);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//    private static final String INSERT_KITCHEN_ORDER =
//        "INSERT INTO kitchen_orders (order_id, item_id, status) VALUES (?, ?, ?)";

    public boolean addKitchenOrder(int orderId, int itemId) {

    String sql = """
        INSERT INTO kitchen (order_id, item_id, cooking_status, order_time)
        VALUES (?, ?, 'PREPARING', NOW())
    """;

    try (Connection conn = mysql.openConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, orderId);
        ps.setInt(2, itemId);

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
}
