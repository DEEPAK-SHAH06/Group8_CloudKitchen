/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import dao.LoginDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Users;
import view.DashBoard;
import view.login;

/**
 *
<<<<<<< HEAD

 * @author deepakshah
 */
public class LoginController {
    
    private final LoginDao logindao = new LoginDao();
    private final login loginView;
    
    public LoginController(login loginView){
        this.loginView = loginView;
        loginView.AddLoginListener(new LoginListener());
    }

    public void open(){
        this.loginView.setVisible(true);
    }
    public void close(){
        this.loginView.dispose();
    }
    
    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){

        try{
            String email = loginView.getEmail().getText();
            String password = loginView.getPassword().getText();
            String role = loginView.getRole().getSelectedItem().toString();

            Users users = new Users(email, password, role);

            boolean login = logindao.login(users, role);

            if(login){
                JOptionPane.showMessageDialog(loginView, "Login Successful!");

                // Open Dashboard
                DashBoard dashboard = new DashBoard();
                dashboard.setVisible(true);

                // Close login window
                loginView.dispose();

            } else {
                JOptionPane.showMessageDialog(loginView, "Invalid email or password. Try again.");
            }

        } catch(Exception ex){
            System.out.println("Login Error: " + ex.getMessage());
        }
    }
        
        
}
    }



