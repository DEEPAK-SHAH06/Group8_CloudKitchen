/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author deepakshah
 */

import model.Item;
import database.MySqlConnection;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemDao {

    MySqlConnection mysql = new MySqlConnection();

    // ================= GET ALL ITEMS =================
    public List<Item> getAllItems() {
        List<Item> list = new ArrayList<>();
        String sql = "SELECT * FROM items";

        try (Connection con = mysql.openConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Item item = new Item(
                        rs.getInt("item_id"), // must be similar to database ko column ko name
                        rs.getString("item_name"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getString("image_path"),
                        rs.getString("availability")
                );
                list.add(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // ================= DELETE ITEM =================
    public void deleteItem(int id) {
    try (Connection con = mysql.openConnection()) {
        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM items WHERE item_id=?"
        );
        ps.setInt(1, id);
        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    // ================= ADD ITEM =================
    public void createItem(Item item) {
        String sql = """
            INSERT INTO items (item_name, category, price, image_path, availability)
            VALUES (?, ?, ?, ?, ?)
        """;

        try (Connection con = mysql.openConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, item.getItemName());
            ps.setString(2, item.getCategory());
            ps.setDouble(3, item.getPrice());
            ps.setString(4, item.getImagePath());
            ps.setString(5, item.getAvailability());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= UPDATE ITEM =================
    public void updateItem(Item item) {
        String sql = """
            UPDATE items 
            SET item_name=?, category=?, price=?, image_path=?, availability=?
            WHERE item_id=?
        """;

        try (Connection con = mysql.openConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, item.getItemName());
            ps.setString(2, item.getCategory());
            ps.setDouble(3, item.getPrice());
            ps.setString(4, item.getImagePath());
            ps.setString(5, item.getAvailability());
            ps.setInt(6, item.getItem_id());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Item> searchItems(String keyword) {

        List<Item> list = new ArrayList<>();
        String sql = "SELECT * FROM items WHERE item_name LIKE ?";
        try (Connection con = mysql.openConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + keyword + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Item item = new Item(
                            rs.getInt("item_id"),
                            rs.getString("item_name"),
                            rs.getString("category"),
                            rs.getDouble("price"),
                            rs.getString("image_path"),
                            rs.getString("availability"));
                    list.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // creating getItemsByCategory() method
    public List<Item> getItemsByCategory(String category) {
        List<Item> list = new ArrayList<>();
        String sql = "SELECT * FROM items WHERE category = ?";
        try (Connection con = mysql.openConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, category);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Item item = new Item(
                            rs.getInt("item_id"),
                            rs.getString("item_name"),
                            rs.getString("category"),
                            rs.getDouble("price"),
                            rs.getString("image_path"),
                            rs.getString("availability"));
                    list.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
