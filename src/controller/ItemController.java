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
import model.Item;
import view.AddItemDashboard;
import view.EditItemDashboard;
import view.ItemPanel;

public class ItemController {

    private ItemPanel panel;
    private JTable table;
    private ItemDao dao = new ItemDao();

    public ItemController(JTable table) {
        this.table = table;
    }

    // ================= LOAD ITEMS =================
    public void loadItems() {
        table.setModel(new ItemTableModel(dao.getAllItems()));
    }

    // ================= ADD =================
    public void addItem() {
        new AddItemDashboard().setVisible(true);
    }

    // ================= EDIT =================
    public void editItem() {
        int row = table.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Select an item to edit");
            return;
        }

        Item item = dao.getAllItems().get(row);
        new EditItemDashboard(item).setVisible(true);
    }
    
    // Afteer closing ADD/Edit window, reload table;
    //table.setModel(loadItems());


    // ================= DELETE =================
    public void deleteItem() {
        int row = table.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Select an item to delete");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to delete this item?",
                "Confirm",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            int itemId = (int) table.getValueAt(row, 0);
            dao.deleteItem(itemId);
            loadItems();
        }
    }

    
    public List<Item> searchItems(String keyword) {
        return dao.searchItems(keyword);
    }

    public List<Item> filterByCategory(String category) {
        return dao.getItemsByCategory(category);
    }
    
    public ItemController(ItemPanel panel){
        this.panel = panel;
        
    }

 
}

