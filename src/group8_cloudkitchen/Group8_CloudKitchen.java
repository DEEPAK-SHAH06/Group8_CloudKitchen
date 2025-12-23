/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package group8_cloudkitchen;

/**
 *
 * @author deepakshah
 */
import controller.ForgetPassController;
import view.login;
import controller.LoginController;
import controller.UserController;
import database.Databasee;
import database.MySqlConnection;
import view.SignUp;
import view.forgetpass;
public class Group8_CloudKitchen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        // Databasee db = new MySqlConnection();
        // if(db.openConnection() != null){
        //     System.out.println("Connection Opened");
        // }else{
        //     System.out.println("Connection Closed");
        // }
        
        // TODO code application logic here
//        SignUp signupview = new SignUp();
//        UserController controller = new UserController(signupview);
//        signupview.setVisible(true);
        

    
        forgetpass fgp = new forgetpass();
        ForgetPassController controller = new ForgetPassController(fgp);
        fgp.setVisible(true);
        
//        login loginview = new login();
//        LoginController controller = new LoginController(loginview);
//        loginview.setVisible(true);
    }
    
}
