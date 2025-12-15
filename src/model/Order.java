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

public class Order {
    
    private int order_id;
    private Customers customer_id;
    private double totalAmount;
    private LocalDateTime orderTime;

    private OrderStatus orderStatus;
    private enum OrderStatus{
        PENDING,
        CONFIRMED,
        PREPARING,
        OUT_FOR_DELIVERY,
        DELIVERED,
        CANCELLED
    }
    public int getOrder_id() {
        return order_id;
    }
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
    public Customers getCustomer_id() {
        return customer_id;
    }
    public void setCustomer_id(Customers customer_id) {
        this.customer_id = customer_id;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public LocalDateTime getOrderTime() {
        return orderTime;
    }
    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    public Order(int order_id, Customers customer_id, double totalAmount, LocalDateTime orderTime,
            Order.OrderStatus orderStatus) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.totalAmount = totalAmount;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
    }

    





}

