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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import tablemodel.OrderTableModel;

public class OrderController {

    private JTable table;
    private OrderDao dao;

    public OrderController(JTable table) {
        this.table = table;
        this.dao = new OrderDao();
    }

    public void loadOrders() {
        table.setModel(new OrderTableModel(dao.getAllOrders()));
    }

    // ================= ASSIGN TO KITCHEN =================
    public void assignToKitchen(int row) {
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Select an order first");
            return;
        }

        int orderId = (int) table.getValueAt(row, 0);

        dao.updateOrderStatus(orderId, "PREPARING");
        dao.insertIntoKitchen(orderId);

        JOptionPane.showMessageDialog(null, "Order assigned to Kitchen");
        loadOrders();
    }

    // ================= CANCEL ORDER =================
    public void cancelOrder(int row) {
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Select an order first");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                null, "Cancel this order?", "Confirm",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            int orderId = (int) table.getValueAt(row, 0);
            dao.deleteOrder(orderId);
            loadOrders();
        }
    }
}
