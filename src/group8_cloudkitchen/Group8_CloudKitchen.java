/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package group8_cloudkitchen;

/**
 *
 * @author deepakshah
 */
import controller.AdminDashboardController;
import controller.DeliveryController;
import controller.DeliveryDashboardController;
import controller.ForgetPassController;
import controller.KitchenDashboardController;
import view.login;
import controller.LoginController;
import controller.MainPageController;
import controller.UserController;
import database.Databasee;
import database.MySqlConnection;
import view.AdminDashboard1;
import view.DeliveryDash;
import view.MainPage;
import view.ProductCardPanel;
import view.SignUp;
import view.forgetpass;
import view.kitchenDash;
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
//        controller.open();
        

    
//        forgetpass fgp = new forgetpass();
//        ForgetPassController controller = new ForgetPassController(fgp);
//        fgp.setVisible(true);
        
        MainPage mp = new MainPage();
        MainPageController controller = new MainPageController(mp);
        controller.open();
        
        
//        DeliveryDash dash = new DeliveryDash();
//        DeliveryDashboardController controller =new DeliveryDashboardController(dash);
//        dash.setVisible(true);
//        kitchenDash dash = new kitchenDash();
//        KitchenDashboardController controller =new KitchenDashboardController(dash);
//        dash.setVisible(true);

//            AdminDashboard1 adView = new AdminDashboard1();
//            AdminDashboardController controller = new AdminDashboardController(adView);
//            controller.open();
        
        
//        login loginview = new login();
//        LoginController controller = new LoginController(loginview);
//        controller.open();
    }
    
}
