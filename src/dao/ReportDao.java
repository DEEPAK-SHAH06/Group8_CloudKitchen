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
import model.Reports;
import java.util.*;
import java.sql.*;

public class ReportDao {

    MySqlConnection mysql = new MySqlConnection();

    public List<Reports> getReports() {

        List<Reports> list = new ArrayList<>();
        String sql = "SELECT * FROM reports ORDER BY start_date DESC";

        try (Connection con = mysql.openConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Reports r = new Reports();

                r.setReport_id(rs.getInt("report_id"));
                r.setStartDate(rs.getDate("start_date").toLocalDate());
                r.setEndDate(rs.getDate("end_date").toLocalDate());
                r.setTotalOrder(rs.getInt("total_order"));
                r.setTotalRevenue(rs.getDouble("total_revenue"));
                r.setMostSoldItem(rs.getString("most_sold_item"));

                list.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}

