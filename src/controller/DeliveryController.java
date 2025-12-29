/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author deepakshah
 */



import dao.DeliveryDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.DeliveryStaff;
import tablemodel.DeliveryTableModel;
import view.DeliveryPanel;
import view.Adddeliveryperson;
import view.Editdeliveryperson;

public class DeliveryController {

    private  DeliveryDao dao = new DeliveryDao();
    private  DeliveryTableModel model;
    private  DeliveryPanel panel;
    

    public DeliveryController(DeliveryPanel panel,DeliveryTableModel model) {
        this.panel =panel;
        this.model = model;
        this.dao = new DeliveryDao();
        this.panel.addButtonListener(new AddButtonListener());
        this.panel.editButtonListener(new AddEditListener());
        this.panel.deleteButtonListener(new DeleteListener());
        
        loadStaff();
    }

    public void loadStaff() {
        model.setStaff(dao.getAllStaff());
    }
    

   

    class AddButtonListener implements ActionListener {

        public AddButtonListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            new Adddeliveryperson().setVisible(true);        
        }
    }

    class AddEditListener implements ActionListener {

        public AddEditListener() {
        }

        @Override
        
        public void actionPerformed(ActionEvent e) {
        int row = panel.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Select a staff first");
            return;
        }

        DeliveryStaff staff = model.getSelectedStaff(row);

        Editdeliveryperson edit = new Editdeliveryperson(
            staff,
            () -> model.setStaff(dao.getAllStaff()) // 🔥 refresh table
        );

        edit.setVisible(true);
    }
    }
        
//     private void deleteStaff() {
//        int row = panel.getSelectedRow();
//        if (row == -1) return;
//
//        DeliveryStaff staff = model.getStaffAt(row);
//        dao.deleteStaff(staff.getDeliveryStaff_id());
//        loadStaff();
//    }
    
    class DeleteListener implements ActionListener {

        public DeleteListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int row = panel.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Select a row first!");
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to delete?",
                "Confirm",
                JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {

                int staffId =
                    (int) model.getValueAt(row, 0);

                if (dao.deleteStaff(staffId)) {
                    JOptionPane.showMessageDialog(null, "Deleted Successfully");
                    loadStaff();
                }
            }

                }
            }
    }

   


