/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author deepakshah
 */
import dao.AdminDao;
import javax.swing.*;
import java.util.List;
import model.Users;
import view.AdminUsersTableModel;

public class AdminController {

    private JTable table;
    private AdminUsersTableModel tableModel;
    private AdminDao dao = new AdminDao();

    public AdminController(JTable table) {
        this.table = table;
        loadUsers();
    }

    public void loadUsers() {
        List<Users> users = dao.getAllUsers();
        tableModel = new AdminUsersTableModel(users);
        table.setModel(tableModel);
    }

    // ADD
    public void addUser(String username, String email, long phone, String role) {

        Users u = new Users();
        u.setUsername(username);
        u.setEmail(email);
        //u.setPhone(phone);
        u.setRole(role);

        if (dao.addUser(u)) {
            JOptionPane.showMessageDialog(null, "User added successfully");
            loadUsers();
        }
    }

    // EDIT
    public void editUser(int row, String username, String email, long phone, String role) {

        Users u = tableModel.getUserAt(row);
        u.setUsername(username);
        u.setEmail(email);
        //u.setPhone(phone);
        u.setRole(role);

        if (dao.updateUser(u)) {
            JOptionPane.showMessageDialog(null, "User updated");
            loadUsers();
        }
    }

    // DELETE
    public void deleteUser(int row) {

        Users u = tableModel.getUserAt(row);

        int confirm = JOptionPane.showConfirmDialog(
                null,
                "Delete selected user?",
                "Confirm",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            if (dao.deleteUser(u.getUser_id())) {
                JOptionPane.showMessageDialog(null, "User deleted");
                loadUsers();
            }
        }
    }
}

