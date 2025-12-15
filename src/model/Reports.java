/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author deepakshah
 */
public class Reports {
    
    private int report_id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String totalOrder;
    private String totalRevenue;
    private String mostSoldItem;

    public int getReport_id() {
        return report_id;
    }
    public void setReport_id(int report_id) {
        this.report_id = report_id;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public String getTotalOrder() {
        return totalOrder;
    }
    public void setTotalOrder(String totalOrder) {
        this.totalOrder = totalOrder;
    }
    public String getTotalRevenue() {
        return totalRevenue;
    }
    public void setTotalRevenue(String totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
    public String getMostSoldItem() {
        return mostSoldItem;
    }
    public void setMostSoldItem(String mostSoldItem) {
        this.mostSoldItem = mostSoldItem;
    }
    public Reports(LocalDate startDate, LocalDate endDate, String totalOrder, String totalRevenue,
            String mostSoldItem) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalOrder = totalOrder;
        this.totalRevenue = totalRevenue;
        this.mostSoldItem = mostSoldItem;
    }

    
    




}

