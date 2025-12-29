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
        "Staff ID", "Name", "Phone", "Vehicle", "Shift"
    };

    private List<DeliveryStaff> staff;

    public DeliveryTableModel(List<DeliveryStaff> staff) {
        this.staff = staff;
    }

    public void setStaff(List<DeliveryStaff> staff) {
        this.staff = staff;
        fireTableDataChanged();
    }
    
    public DeliveryStaff getSelectedStaff(int row) {
        if (row < 0 || row >= staff.size()) return null;
        return staff.get(row);
    }

    public List<DeliveryStaff> getStaffList() {
        return staff;
    }

    @Override public int getRowCount() {
        return staff == null ? 0 : staff.size();
    }

    @Override public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int r, int c) {

        DeliveryStaff d = staff.get(r);

        return switch (c) {
            case 0 -> d.getDeliveryStaff_id();
            case 1 -> d.getName();
            case 2 -> d.getPhone();
            case 3 -> d.getVehicleType();
            case 4 -> d.getShift();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int c) {
        return cols[c];
    }
    
    private int deliveryStaff_id;

    public int getDeliveryStaff_id() {
        return deliveryStaff_id;
    }

    public void setDeliveryStaff_id(int deliveryStaff_id) {
        this.deliveryStaff_id = deliveryStaff_id;
    }
}

