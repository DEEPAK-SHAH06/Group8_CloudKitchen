/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.MySqlConnection;
import java.util.List;
import model.CartItem;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author deepakshah
 */
public class CartDao {
    MySqlConnection mysql = new MySqlConnection();

    public void saveCart(int userId, List<CartItem> items) {
        String deleteSql = "DELETE FROM cart_items WHERE user_id = ?";
        String insertSql = """
            INSERT INTO cart_items (user_id, item_id, quantity, price)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection con = mysql.openConnection()) {

            // Clear old cart
            try (PreparedStatement ps = con.prepareStatement(deleteSql)) {
                ps.setInt(1, userId);
                ps.executeUpdate();
            }

            // Insert new cart
            try (PreparedStatement ps = con.prepareStatement(insertSql)) {
                for (CartItem item : items) {
                    ps.setInt(1, userId);
                    ps.setInt(2, item.getItemId());
                    ps.setInt(3, item.getQuantity());
                    ps.setDouble(4, item.getPrice());
                    ps.addBatch();
                }
                ps.executeBatch();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<CartItem> loadCart(int userId) {
    List<CartItem> items = new ArrayList<>();

    String sql = """
        SELECT c.item_id, c.quantity, c.price, i.item_name, i.image_path
        FROM cart_items c
        JOIN items i ON c.item_id = i.item_id
        WHERE c.user_id = ?
    """;

    try (Connection con = mysql.openConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            CartItem item = new CartItem(
                rs.getInt("item_id"),
                rs.getString("item_name"),
                rs.getDouble("price"),
                rs.getString("image_path")
            );
            item.setQuantity(rs.getInt("quantity"));
            items.add(item);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return items;
}

}
