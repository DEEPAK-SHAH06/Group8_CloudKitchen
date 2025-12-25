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
import model.DeliveryOrder;
import tablemodel.DeliveryDashboardTableModel;
import view.DeliveryDash;
import view.login;

/**
 *
 * @author deepakshah
 */
public class DeliveryDashboardController {
    
    private DeliveryDao dao = new DeliveryDao();
    private DeliveryDash view;

    public DeliveryDashboardController(DeliveryDash view) {
        this.view = view;

        loadTable();

        view.pickedUpListener(e -> updateStatus("PREPARING"));
        view.enRouteListener(e -> updateStatus("OUT_FOR_DELIVERY"));
        view.deliveredListener(e -> updateStatus("DELIVERED"));
        view.backBtnListener(new Addbackbtnlistener());
    }
    
    public void open(){
        this.view.setVisible(true);
    }
    
    public void close(){
        this.view.dispose();
    }

    private void loadTable() {
        List<DeliveryOrder> list = dao.getDeliveryOrders();
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

        public Addbackbtnlistener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            login lc = new login();
            LoginController log = new LoginController(lc);
            log.close();
            log.open();
        }
    }
    
}
