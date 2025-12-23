/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author deepakshah
 */


import dao.ItemDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tablemodel.ItemTableModel;

import javax.swing.*;
import java.util.List;
import view.ItemPanel;

public class ItemController {

    private JTable table;
    private ItemDao dao = new ItemDao();
    private ItemPanel panel;

    public ItemController(JTable table) {
        this.table = table;
    }

    public ItemTableModel loadItems() {
        return new ItemTableModel(dao.getAllItems());
    }

    public void addItem() {
        JOptionPane.showMessageDialog(null, "Add Item Clicked");
    }

    public void editItem(int row) {
        if (row == -1) return;
        JOptionPane.showMessageDialog(null, "Edit Item ID: " + table.getValueAt(row, 0));
    }

    public void deleteItem(int row) {
        if (row == -1) return;
        dao.deleteItem((int) table.getValueAt(row, 0));
        table.setModel(loadItems());
    }
    
    public ItemController(ItemPanel panel){
        this.panel = panel;
        
        panel.addItemListener(new AddItemListener());
    }

   class AddItemListener implements ActionListener {

        public AddItemListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // logic here
        }
    }
}

