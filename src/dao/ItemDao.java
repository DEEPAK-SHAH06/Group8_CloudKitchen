/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import database.MySqlConnection;
import java.util.ArrayList;
import java.util.List;
import model.Item;

/**
 *
 * @author deepakshah
 */
public class ItemDao {

    MySqlConnection mysql = new MySqlConnection();

    public List<Item> getAvailableItems() {

        List<Item> items = new ArrayList<>();
        Connection conn = mysql.openConnection();

        String sql = "SELECT * FROM items WHERE availability = 'AVAILABLE'";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Item item = new Item();
                item.setItem_id(rs.getInt("item_id"));
                item.setItemName(rs.getString("item_name"));
                item.setPrice(rs.getDouble("price"));
                item.setImagePath(rs.getString("image_path"));

                items.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysql.closeConnection(conn);
        }

        return items;
    }
}

