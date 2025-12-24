/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.DeliveryA;


/**
 *
 * @author Limbu Mbg Sujata
 */
public class AddDeliveryDao {
    MySqlConnection mysqlConnection = new MySqlConnection();
    Connection conn = mysqlConnection.openConnection();
	public boolean addDelivery(DeliveryA delivery) {
		String query = "INSERT INTO delivery (staff_name, phone, email, password, shift, vehicle_type) VALUES (?, ?, ?, ?, ?, ?)";

		     try 
			(PreparedStatement pst = conn.prepareStatement(query)) {

			pst.setString(1, delivery.getStaffName());
			pst.setString(2, delivery.getPhone());
			pst.setString(3, delivery.getEmail());
			pst.setString(4, delivery.getPassword());
			pst.setString(5, delivery.getShift());
			pst.setString(6, delivery.getVehicleType());

			int result = pst.executeUpdate();
			return result > 0;
		} catch (SQLException e) {
			System.out.println("Error adding delivery staff: " + e.getMessage());
			return false;
		}
	}

    
    
}
