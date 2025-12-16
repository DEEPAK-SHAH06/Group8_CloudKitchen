/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.LoginDao;
import dao.SignUpDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Users;
import view.SignUp;

/**
 *
 * @author deepakshah
 */
public class UserController {
    
    private final SignUpDao signupdao = new SignUpDao();
    private final SignUp userView;
   
    public UserController(SignUp userView){
        this.userView = userView;
        userView.AddUserListener(new AddActionListener());
    }
    
    public void open(){
        this.userView.setVisible(true);
    }
    public void close(){
        this.userView.dispose();
    }

    class AddActionListener implements ActionListener {

        public void actionPerformed(ActionEvent ex) {
            
            try{
                
                String username = userView.getUsernameText().getText();
                String email = userView.getEmailText().getText();
                String password = userView.getPasswordText().getText();
                
                Users users = new Users(username, email, password);
                boolean check = signupdao.checkExists(users);
                if (check) {
                    JOptionPane.showConfirmDialog(userView, "Duplicated user");
                } else {
                    signupdao.signUp(users);
                    JOptionPane.showMessageDialog(userView, "Successfull");
//                    Login lc = new Login();
//                    LoginController log = new LoginController(lc);
//                    log.close();
//                    log.open();
                }
           
            }catch(Exception e){
                System.out.println(e);
            }
     }
    }
    
    
    
}
    

