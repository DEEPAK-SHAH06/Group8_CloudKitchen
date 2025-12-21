/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodel;

/**
 *
 * @author deepakshah
 */


import model.Item;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ItemTableModel extends AbstractTableModel {

    private final String[] columns = {
        "Item ID", "Name", "Category", "Price", "Availability"
    };

    private List<Item> items;

    public ItemTableModel(List<Item> items) {
        this.items = items;
    }

    public int getRowCount() {
        return items.size();
    }

    public int getColumnCount() {
        return columns.length;
    }

    public String getColumnName(int col) {
        return columns[col];
    }

    public Object getValueAt(int row, int col) {
        Item i = items.get(row);
        return switch (col) {
            case 0 -> i.getItem_id();
            case 1 -> i.getItemName();
            case 2 -> i.getCategory();
            case 3 -> i.getPrice();
            case 4 -> i.getAvailability();
            default -> null;
        };
    }
}

