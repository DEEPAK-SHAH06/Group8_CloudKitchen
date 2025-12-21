/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UserDao;
import tablemodel.UserTableModel;

/**
 *
 * @author deepakshah
 */
public class UserTController {
     private final UserDao userDao = new UserDao();
    private final UserTableModel model;

    public UserTController(UserTableModel model) {
        this.model = model;
    }

    public void loadUsers() {
        model.setUsers(userDao.getAllUsers());
    }
}
