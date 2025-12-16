/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

<<<<<<< HEAD
=======
import dao.LoginDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Users;
import view.MainPage;
>>>>>>> 5c0f012051cac98326ce28636a2a6ba075c3f7f6
import view.login;

/**
 *
<<<<<<< HEAD
 * @author Limbu Mbg Sujata
 */
public class LoginController {

    public LoginController(login loginView) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void open() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
=======
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
                MainPage dashboard = new MainPage();
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


>>>>>>> 5c0f012051cac98326ce28636a2a6ba075c3f7f6
