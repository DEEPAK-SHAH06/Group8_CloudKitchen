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

public class DeliveryDao {
    
    private MySqlConnection mysql;

    public List<DeliveryStaff> getAllStaff() {
        List<DeliveryStaff> list = new ArrayList<>();
        String sql = "SELECT * FROM delivery_staff";

        try (Connection con = mysql.openConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
//                DeliveryStaff d = new DeliveryStaff();
//                d.setDeliveryStaff_id(rs.getInt("staff_id"));
//                d.setDeliveryStaff_name(rs.getString("name"));
//                d.setDeliveryStaff_email(rs.getString("phone")); // replce with phone
//                d.setDeliveryStaff_password(rs.getString("vehicle_type")); // replace with vehicle type
//                d.setShift(rs.getString("status")); // replace with status
//                list.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

