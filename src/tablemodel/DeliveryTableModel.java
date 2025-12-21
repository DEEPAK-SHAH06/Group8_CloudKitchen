/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodel;

/**
 *
 * @author deepakshah
 */


import model.DeliveryStaff;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class DeliveryTableModel extends AbstractTableModel {

    private final String[] cols = {
        "Staff ID", "Name", "Phone", "Vehicle", "Status"
    };
    private List<DeliveryStaff> staff;

    public DeliveryTableModel(List<DeliveryStaff> staff) {
        this.staff = staff;
    }

    public void setStaff(List<DeliveryStaff> staff) {
        this.staff = staff;
        fireTableDataChanged();
    }

    @Override public int getRowCount() { return staff.size(); }
    @Override public int getColumnCount() { return cols.length; }

    @Override
    public Object getValueAt(int r, int c) {
        DeliveryStaff d = staff.get(r);
        return switch (c) {
            case 0 -> d.getDeliveryStaff_id();
            case 1 -> d.getDeliveryStaff_name();
            case 2 -> d.getDeliveryStaff_email();// replace with phone
            case 3 -> d.getDeliveryStaff_email();// vehicle type
            case 4 -> d.getShift();// replace status
            default -> null;
        };
    }

    @Override
    public String getColumnName(int c) {
        return cols[c];
    }
}
