/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodel;
import model.DeliveryOrder;

import javax.swing.table.AbstractTableModel;
import java.util.List;
/**
 *
 * @author deepakshah
 */
public class DeliveryDashboardTableModel extends AbstractTableModel {
    private final String[] columns = {
            "Order ID", "Customer Name", "Address",
            "Phone Number", "Delivery Time", "Status"
    };

    private List<DeliveryOrder> list;

    public DeliveryDashboardTableModel(List<DeliveryOrder> list) {
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
    public String getColumnName(int col) {
        return columns[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        DeliveryOrder d = list.get(row);

        return switch (col) {
            case 0 -> d.getOrderId();
            case 1 -> d.getCustomerName();
            case 2 -> d.getAddress();
            case 3 -> d.getPhone();
            case 4 -> d.getOrderTime();
            case 5 -> d.getStatus();
            default -> null;
        };
    }
}
