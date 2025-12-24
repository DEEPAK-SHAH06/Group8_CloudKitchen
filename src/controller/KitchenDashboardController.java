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
import model.KitchenOrder;
import tablemodel.KitchenTableModel;
import view.kitchenDash;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;
import tablemodel.KitchenDashboardTableModel;

public class KitchenDashboardController {

    private final kitchenDash view;
    private final KitchenDao dao = new KitchenDao();

    public KitchenDashboardController(kitchenDash view) {
        this.view = view;

        loadTable();

        view.startCookingListener(startCooking());
        view.markReadyListener(markReady());
    }

    private void loadTable() {
        List<KitchenOrder> orders = dao.getKitchenOrders();
        view.getKitchenTable().setModel(new KitchenDashboardTableModel(orders));
    }

    private ActionListener startCooking() {
        return e -> updateStatus("PREPARING");
    }

    private ActionListener markReady() {
        return e -> updateStatus("COOKED");
    }

    private void updateStatus(String status) {
        int row = view.getKitchenTable().getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(view, "Select an order first!");
            return;
        }

        KitchenDashboardTableModel model =
                (KitchenDashboardTableModel) view.getKitchenTable().getModel();

        KitchenOrder order = model.getOrderAt(row);
        dao.updateCookingStatus(order.getKitchenId(), status);
        loadTable();
    }
}

