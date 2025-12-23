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
    
    
    
//    public void loadProducts() {
//
//        cardsPanel.removeAll();
//
//        ItemDao itemDao = new ItemDao();
//        List<Item> items = itemDao.getAllItems();
//
//        for (Item item : items) {
//            ProductCardPanel card = new ProductCardPanel(item);
//            cardsPanel.add(card);
//        }
//
//        cardsPanel.revalidate();
//        cardsPanel.repaint();
//    }
//    

    public List<Item> getAllItems() {
        List<Item> list = new ArrayList<>();
        String sql = "SELECT * FROM items";

        try (Connection con = mysql.openConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Item(                       
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getString("imagePath")
                ));
            }
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
    
    
    public void createItem(Item item){
        Connection conn = mysql.openConnection();
        
        String sql = "INSERT INTO items (itemName, category, price, imagePath) VALUES(?,?,?,?)";
        try(PreparedStatement pstm = conn.prepareStatement(sql)){
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
    
    
    public void updateItem(Item item){
        Connection conn = mysql.openConnection();
        String sql = "UPDATE items SET itemName=?, imagePath=?, price=? WHERE id=?";


        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, item.getItemName());
            pstmt.setString(2, item.getImagePath());
            pstmt.setDouble(3,item.getPrice() );
            pstmt.setInt(4, item.getItem_id()); 
            pstmt.executeUpdate();


            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            mysql.closeConnection(conn);
        }
    }
    
    
}


