/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author deepakshah
 */
import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Customers;
import model.Users;

public class AdminUsersTableModel extends AbstractTableModel {

    private final String[] columns = {
        "User ID", "Username", "Email", "Phone", "Role"
    };

    private List<Users> users;
    private List<Customers> customers;

    public AdminUsersTableModel(List<Users> users) {
        this.users = users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return users == null ? 0 : users.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Users u = users.get(row);
        Customers c = customers.get(row);
        return switch (col) {
            case 0 -> u.getUser_id();
            case 1 -> u.getUsername();
            case 2 -> u.getEmail();
            case 3 -> c.getPhone();
            case 4 -> u.getRole();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int col) {
        return columns[col];
    }

    public Users getUserAt(int row) {
        return users.get(row);
    }
}
