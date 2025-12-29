/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DeliveryDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import model.DeliveryOrder;
import tablemodel.DeliveryDashboardTableModel;
import utils.UserSession;
import view.DeliveryDash;
import view.login;

/**
 *
 * @author deepakshah
 */

public class DeliveryDashboardController {

    private DeliveryDao dao = new DeliveryDao();
    private DeliveryDash view;

    private Timer refreshTimer;

    public DeliveryDashboardController(DeliveryDash view) {
        this.view = view;

        loadTable();
        startAutoRefresh(); // 🔁 auto refresh

        view.pickedUpListener(e -> updateStatus("ON_THE_WAY"));
        view.enRouteListener(e -> updateStatus("OUT_FOR_DELIVERY"));
        view.deliveredListener(e -> updateStatus("DELIVERED"));
        view.backBtnListener(new Addbackbtnlistener());
    }

    public void open() {
        view.setVisible(true);
    }

    public void close() {
        stopAutoRefresh();
        view.dispose();
    }

    // 🔁 Auto-refresh every 5 seconds
    private void startAutoRefresh() {
        refreshTimer = new Timer(5000, e -> loadTable());
        refreshTimer.start();
    }

    private void stopAutoRefresh() {
        if (refreshTimer != null) {
            refreshTimer.stop();
        }
    }

    private void loadTable() {
        int userId = UserSession.getUserId();
        int deliveryStaffId = dao.getDeliveryStaffIdByUserId(userId);

        if (deliveryStaffId == -1) {
            JOptionPane.showMessageDialog(view, "Delivery staff not found");
            return;
        }

        List<DeliveryOrder> list = dao.getDeliveryOrdersByStaff(deliveryStaffId);
        view.getTable().setModel(new DeliveryDashboardTableModel(list));
    }

    private void updateStatus(String status) {
        int row = view.getTable().getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(view, "Select an order first");
            return;
        }

        int orderId = (int) view.getTable().getValueAt(row, 0);
        dao.updateOrderStatus(orderId, status);
        loadTable();
    }

    class Addbackbtnlistener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            stopAutoRefresh(); // ⛔ stop timer on logout
            login lc = new login();
            LoginController log = new LoginController(lc);
            log.open();
            view.dispose();
        }
    }
}
