/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AddUserDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Users;


import view.Adduser;


/**
 *
 * @author Limbu Mbg Sujata
 */
public class AddUserController {

    private final Adduser view;
    private final AddUserDao dao;
    // connectes view with controller
    public AddUserController(Adduser view) {
        this.view = view;
        this.dao = new AddUserDao();

        // Add button listener
        this.view.getAddButton().addActionListener(new AddButtonListener());
    }

    // Inner class to handle the Add button click
    private class AddButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //get input value from the from fields
            String username = view.getUsername().getText();
            String email = view.getEmail().getText();
            String password = view.getPassword().getText();
            
              // check if any fields is empty
            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(view, "All fields are required");
                return;
            }
            
            // Create user model object with form data
            Users user = new Users(username, email, password);
            
            // calln Dao method to insert user into database
            if (dao.Adduser(user)) {
                
                JOptionPane.showMessageDialog(view, "User added successfully");
                
                // clear input fields after successful insert
                view.getUsername().setText("");
                view.getEmail().setText("");
                view.getPassword().setText("");
            } else {
                //show error message if insert fails
                JOptionPane.showMessageDialog(view, "Failed to add user");
            }
        }
    }
   
}