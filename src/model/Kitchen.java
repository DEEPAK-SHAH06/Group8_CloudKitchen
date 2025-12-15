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
    
    private Order order_id;
    private Customers customer_id;
    private Item itemName;
    private CookingStatus cookingStatus;

    private enum CookingStatus{
        PREPARING,COOKED
    }

    private LocalDateTime orderTime;

    public Order getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Order order_id) {
        this.order_id = order_id;
    }

    public Customers getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customers customer_id) {
        this.customer_id = customer_id;
    }

    public Item getItemName() {
        return itemName;
    }

    public void setItemName(Item itemName) {
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

    public Kitchen(Order order_id, Customers customer_id, Item itemName, Kitchen.CookingStatus cookingStatus,
            LocalDateTime orderTime) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.itemName = itemName;
        this.cookingStatus = cookingStatus;
        this.orderTime = orderTime;
    }

   

    






}
