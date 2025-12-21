/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author deepakshah
 */

import dao.OrderDao;
import tablemodel.OrderTableModel;

public class OrderController {

    private final OrderDao dao = new OrderDao();
    private final OrderTableModel model;

    public OrderController(OrderTableModel model) {
        this.model = model;
    }

    public void loadOrders() {
        model.setOrders(dao.getAllOrders());
    }
}

