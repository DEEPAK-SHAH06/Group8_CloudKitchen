/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package group8_cloudkitchen;

/**
 *
 * @author deepakshah
 */
import view.login;
import controller.LoginController;
import database.Databasee;
import database.MySqlConnection;
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
        login loginView = new login();
        LoginController loginCOntroller = new LoginController(loginView);
        loginView.setVisible(true);
    }
    
}
