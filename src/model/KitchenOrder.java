/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author deepakshah
 */


import java.time.LocalDateTime;

public class KitchenOrder {

    private int kitchenId;
    private int orderId;
    private String customerName;
    private String itemName;
    private String cookingStatus;
    private LocalDateTime orderTime;

    public KitchenOrder(int kitchenId, int orderId, String customerName,
                        String itemName, String cookingStatus, LocalDateTime orderTime) {
        this.kitchenId = kitchenId;
        this.orderId = orderId;
        this.customerName = customerName;
        this.itemName = itemName;
        this.cookingStatus = cookingStatus;
        this.orderTime = orderTime;
    }

    public int getKitchenId() { return kitchenId; }
    public int getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public String getItemName() { return itemName; }
    public String getCookingStatus() { return cookingStatus; }
    public LocalDateTime getOrderTime() { return orderTime; }

    public void setKitchenId(int kitchenId) {
        this.kitchenId = kitchenId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setCookingStatus(String cookingStatus) {
        this.cookingStatus = cookingStatus;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    
}

