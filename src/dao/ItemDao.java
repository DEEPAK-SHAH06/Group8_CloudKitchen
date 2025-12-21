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

public class ItemDao {
    
    MySqlConnection mysql = new MySqlConnection();
    

    public List<Item> getAllItems() {
        List<Item> list = new ArrayList<>();
        String sql = "SELECT * FROM items";

        try (Connection con = mysql.openConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

//            while (rs.next()) {
//                list.add(new Item(                       
//                        rs.getInt("id"),
//                        rs.getString("name"),
//                        rs.getString("category"),
//                        rs.getDouble("price"),
//                        rs.getBoolean("availability")
//                ));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void deleteItem(int id) {
        try (Connection con = mysql.openConnection()) {
            PreparedStatement ps =
                con.prepareStatement("DELETE FROM items WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


