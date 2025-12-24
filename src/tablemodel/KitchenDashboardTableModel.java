/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodel;

/**
 *
 * @author deepakshah
 */
import model.KitchenOrder;

import javax.swing.table.AbstractTableModel;
import java.util.List;
public class KitchenDashboardTableModel extends AbstractTableModel {
    private final String[] columns = {
            "Order ID", "Status", "Customer", "Item", "Time"
    };

    private final List<KitchenOrder> list;

    public KitchenDashboardTableModel(List<KitchenOrder> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int row, int col) {
        KitchenOrder k = list.get(row);

        return switch (col) {
            case 0 -> k.getOrderId();
            case 1 -> k.getCookingStatus();
            case 2 -> k.getCustomerName();
            case 3 -> k.getItemName();
            case 4 -> k.getOrderTime();
            default -> null;
        };
    }

    public KitchenOrder getOrderAt(int row) {
        return list.get(row);
    }
}
