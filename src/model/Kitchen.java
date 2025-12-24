/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author deepakshah
 */
public class Kitchen {
    
    private int order_id; // Foreign Key Order
    private int customer_id; // FK Customers
    private String itemName; // Foreign key Item
    private CookingStatus cookingStatus;

    

    public enum CookingStatus{
        PREPARING,COOKED
    }

    private LocalDateTime orderTime;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public CookingStatus getCookingStatus() {
        return cookingStatus;
    }

    public void setCookingStatus(CookingStatus cookingStatus) {
        this.cookingStatus = cookingStatus;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public Kitchen(int order_id, int customer_id, String itemName, CookingStatus cookingStatus,
            LocalDateTime orderTime) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.itemName = itemName;
        this.cookingStatus = cookingStatus;
        this.orderTime = orderTime;
    }
    
    public Kitchen(Order order, Customers customer, Item item, CookingStatus cookingStatus, LocalDateTime toLocalDateTime) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    






}
