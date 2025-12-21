/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodel;

/**
 *
 * @author deepakshah
 */


import model.Order;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class OrderTableModel extends AbstractTableModel {

    private final String[] cols = {
        "Order ID", "Customer ID", "Total Amount", "Order Time", "Status"
    };
    private List<Order> orders;

    public OrderTableModel(List<Order> orders) {
        this.orders = orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
        fireTableDataChanged();
    }

    @Override public int getRowCount() { return orders.size(); }
    @Override public int getColumnCount() { return cols.length; }

    @Override
    public Object getValueAt(int r, int c) {
        Order o = orders.get(r);
        return switch (c) {
            case 0 -> o.getOrder_id();
            case 1 -> o.getCustomer_id();
            case 2 -> o.getTotalAmount();
            case 3 -> o.getOrderTime();
            case 4 -> o.getOrderStatus();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int c) {
        return cols[c];
    }
}

