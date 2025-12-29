/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodel;

import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Kitchen;

/**
 *
 * @author deepakshah
 */
public class KitchenTableModel extends AbstractTableModel{

    private final String[] columnNames = {
        "Order ID",
        "Status",
        "Customer",
        "Item",
        "Order Time"
    };

    private List<Kitchen> kitchenOrders;

    public KitchenTableModel(List<Kitchen> kitchenOrders) {
        this.kitchenOrders = kitchenOrders;
    }

    @Override
    public int getRowCount() {
        return kitchenOrders == null ? 0 : kitchenOrders.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Kitchen kitchen = kitchenOrders.get(rowIndex);

        switch (columnIndex) {

            case 0: // Order ID
                return kitchen.getOrder_id();

            case 1: // Status
                return kitchen.getCookingStatus().name();

            case 2: // Customer
                return kitchen.getCustomer_id();

            case 3: // Item
                return kitchen.getItemName();

            case 4: // Time
                return kitchen.getOrderTime()
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

            default:
                return null;
        }
    }

    // Used when refreshing table data
    public void setKitchenOrders(List<Kitchen> kitchenOrders) {
        this.kitchenOrders = kitchenOrders;
        fireTableDataChanged();
    }

    //  Helpful for controller (row selection)
    public Kitchen getKitchenAt(int row) {
        return kitchenOrders.get(row);
    }
    
}
