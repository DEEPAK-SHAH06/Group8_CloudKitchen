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

    public List<Item> getAllItems() {
        List<Item> list = new ArrayList<>();
        String sql = "SELECT * FROM items";

        try (Connection con = mysql.openConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Item item = new Item(
                        rs.getInt("item_id"), // rs.next("something") garda Database ko column name sanga similar hunu
                                              // parxa
                        rs.getString("item_name"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getString("image_path"),
                        rs.getString("availability"));
                list.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteItem(int id) {
        try (Connection con = mysql.openConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM items WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createItem(Item item) {
        Connection conn = mysql.openConnection();

        String sql = "INSERT INTO items (itemName, category, price, imagePath) VALUES(?,?,?,?)";
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, item.getItemName());
            pstm.setString(2, item.getCategory());
            pstm.setDouble(3, item.getPrice());
            pstm.setString(4, item.getImagePath());

            pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysql.closeConnection(conn);
        }
    }

    public void updateItem(Item item) {
        Connection conn = mysql.openConnection();
        String sql = "UPDATE items SET itemName=?, imagePath=?, price=? WHERE id=?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, item.getItemName());
            pstmt.setString(2, item.getImagePath());
            pstmt.setDouble(3, item.getPrice());
            pstmt.setInt(4, item.getItem_id());
            pstmt.executeUpdate();

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            mysql.closeConnection(conn);
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
