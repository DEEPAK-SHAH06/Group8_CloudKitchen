/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UserDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Users;
import tablemodel.UserTableModel;
import view.Adduser;
import view.Edituserinfo;
import view.UserPanel;

/**
 *
 * @author deepakshah
 */
public class UserTController {

    private final UserDao dao = new UserDao();
    private final UserTableModel model;
    private final JTable table;
    private final UserPanel panel;

    public UserTController(UserPanel panel, UserTableModel model, JTable table) {
        this.panel = panel;
        this.model = model;
        this.table = table;

        panel.userAddbtn(new addUserListener());
        panel.userDeleteBtn(new deleteUserListener());
        panel.userEditBtn(new editUserListener());

        loadUsers();
    }

    public void loadUsers() {
        model.setUsers(dao.getAllUsers());
    }

    // ADD → open AddUserDashboard
    public void addUser() {
        new Adduser().setVisible(true);
    }

    // EDIT → open EditUserDashboard
    public void editUser() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Select a user first");
            return;
        }

        Users u = model.getUserAt(row);
        new Edituserinfo(u).setVisible(true);
    }

    // DELETE
    public void deleteUser() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Select a user first");
            return;
        }

        Users u = model.getUserAt(row);

        int confirm = JOptionPane.showConfirmDialog(
                null,
                "Delete user: " + u.getUsername() + "?",
                "Confirm",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            if (dao.deleteUser(u.getUser_id())) {
                JOptionPane.showMessageDialog(null, "User deleted");
                loadUsers();
            }
        }
    }

    class addUserListener implements ActionListener {

        public addUserListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            addUser();
        }
    }

    class deleteUserListener implements ActionListener {

        public deleteUserListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            deleteUser();
        }
    }

    class editUserListener implements ActionListener {

        public editUserListener() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            editUser();
        }
    }
}