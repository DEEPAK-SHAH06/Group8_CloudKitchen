/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author deepakshah
 */


import dao.KitchenDao;
import model.Kitchen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import tablemodel.KitchenTableModel;

public class KitchenController {

    private final KitchenDao kitchenDao;
    private final JTable kitchenTable;

    public KitchenController(JTable kitchenTable) {
        this.kitchenTable = kitchenTable;
        this.kitchenDao = new KitchenDao();
    }

    // Load table data
    public void loadKitchenOrders() {

        DefaultTableModel model = (DefaultTableModel) kitchenTable.getModel();
        model.setRowCount(0);

        List<Kitchen> orders = kitchenDao.getKitchenOrders();

        for (Kitchen k : orders) {
            model.addRow(new Object[]{
                k.getOrder_id(),
                k.getCookingStatus(),
                k.getCustomer_id(),
                k.getItemName(),
                k.getOrderTime()
            });
        }
    }

    // Start Cooking
    public void startCooking() {

        int selectedRow = kitchenTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select an order first!");
            return;
        }

        int orderId = (int) kitchenTable.getValueAt(selectedRow, 0);

        if (kitchenDao.updateOrderStatus(orderId, "PREPARING")) {
            JOptionPane.showMessageDialog(null, "Cooking started!");
            loadKitchenOrders();
        }
    }

    // Mark as Ready
    public void markAsReady() {

        int selectedRow = kitchenTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select an order first!");
            return;
        }

        int orderId = (int) kitchenTable.getValueAt(selectedRow, 0);

        if (kitchenDao.updateOrderStatus(orderId, "CONFIRMED")) {
            JOptionPane.showMessageDialog(null, "Order ready for delivery!");
            loadKitchenOrders();
        }
    }
}

