/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodel;

/**
 *
 * @author deepakshah
 */

import model.Reports;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ReportTableModel extends AbstractTableModel {

    private final String[] cols = {
        "Report ID", "Date Range", "Total Orders", "Revenue", "Most Sold Item"
    };

    private List<Reports> reports;

    public ReportTableModel(List<Reports> reports) {
        this.reports = reports;
    }

    public void setReports(List<Reports> reports) {
        this.reports = reports;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return reports == null ? 0 : reports.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int r, int c) {
        Reports rep = reports.get(r);

        return switch (c) {
            case 0 -> rep.getReport_id();
            case 1 -> rep.getStartDate() + " to " + rep.getEndDate(); // ✅ DATE RANGE
            case 2 -> rep.getTotalOrder();
            case 3 -> rep.getTotalRevenue();
            case 4 -> rep.getMostSoldItem();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int c) {
        return cols[c];
    }
}


