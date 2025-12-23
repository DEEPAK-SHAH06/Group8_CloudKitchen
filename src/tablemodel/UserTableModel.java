/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodel;

/**
 *
 * @author deepakshah
 */


import model.Users;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class UserTableModel extends AbstractTableModel {

    private final String[] columns = {
        "User ID", "Username", "Email", "Phone", "Role"
    };

    private List<Users> users;

    public UserTableModel(List<Users> users) {
        this.users = users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Users u = users.get(row);
        return switch (col) {
            case 0 -> u.getUser_id();
            case 1 -> u.getUsername();
            case 2 -> u.getEmail();
            case 3 -> u.getPhone(); 
            case 4 -> u.getRole();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int col) {
        return columns[col];
    }
}

