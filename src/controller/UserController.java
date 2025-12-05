/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.LoginDao;
import dao.SignUpDao;

/**
 *
 * @author deepakshah
 */
public class UserController {
    
    private final SignUpDao signupdao = new SignUpDao();
    private final SignUp userView;
   
    public UserController(SignUp userView){
        this.userView = userView;
        userView.AddUserListener(new AddActionListner());
    }
    
    public void open(){
        this.userView.setVisible(true);
    }
    public void close(){
        this.userView.dispose();
    }
    
    class AddActionListener implement ActionListener{
        
        @Override 
        public void actionPerformed(ActionEvent ex){
            
            try{
                public Users handleLogin(String email, String password, String role) {

                 if (email.isEmpty() || password.isEmpty() || role.isEmpty()) {
                    System.out.println("Please fill all fields!");
                    return null;
                }

                Users loggedUser = loginDao.login(email, password, role);

                if (loggedUser == null) {
                     System.out.println("Invalid credentials or wrong role selected!");
                    return null;
                }

                return loggedUser;
            }
            }
            
        }
        
    }
    
}
