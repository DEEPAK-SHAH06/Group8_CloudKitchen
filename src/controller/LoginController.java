/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CartDao;
import dao.LoginDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Users;
import utils.UserSession;
import view.MainPage;
import view.login;
import java.sql.*;
import java.util.List;
import model.CartItem;
import view.AdminDashboard1;
import view.kitchenDash;
import utils.AuthConstants;
import utils.PasswordUtil;
import utils.ValidationUtil;
import view.DeliveryDash;

/**
 *
 * <<<<<<< HEAD
 * 
 * @author deepakshah
 */
public class LoginController {

    private final LoginDao logindao = new LoginDao();
    private final login loginView;
    private MainPageController controller;
    private MainPage mainpage;

    public LoginController(login loginView) {
        this.loginView = loginView;
        loginView.AddLoginListener(new LoginListener());
    }

    public void open() {
        this.loginView.setVisible(true);
    }

    public void close() {
        this.loginView.dispose();
    }

    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                String email = loginView.getEmail().getText().trim();
                String password = loginView.getPassword().getText().trim();

                if (email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(loginView, "Please fill all fields");
                    return;
                }

                // ✅ EMAIL FORMAT CHECK
                if (!ValidationUtil.isValidEmail(email)) {
                    JOptionPane.showMessageDialog(loginView, "Invalid email format");
                    return;
                }
                String role = loginView.getRole().getSelectedItem().toString();

                // ================= ADMIN FIXED LOGIN =================
                if (role.equals("ADMIN")) {
                    if (email.equals("admin@cloudkitchen.com") && password.equals("admin123")) {

                        Users admin = new Users();
                        admin.setUsername("Admin");
                        admin.setRole("ADMIN");

                        UserSession.login(admin);

                        JOptionPane.showMessageDialog(loginView, "Admin Login Successful!");
                        AdminDashboard1 ap = new AdminDashboard1();
                        AdminDashboardController controller = new AdminDashboardController(ap);
                        controller.open();
                        loginView.dispose();
                        return;
                    } else {
                        JOptionPane.showMessageDialog(loginView, "Invalid Admin Credentials");
                        return;
                    }
                }

                // ================= KITCHEN FIXED LOGIN =================
                if (role.equals("KITCHEN")) {
                    if (email.equals("kitchen@cloudkitchen.com") && password.equals("kitchen123")) {

                        Users kitchen = new Users();
                        kitchen.setUsername("Kitchen Staff");
                        kitchen.setRole("KITCHEN");

                        UserSession.login(kitchen);

                        JOptionPane.showMessageDialog(loginView, "Kitchen Login Successful!");
                        kitchenDash kp = new kitchenDash();
                        KitchenDashboardController controller = new KitchenDashboardController(kp);
                        controller.open();
                        loginView.dispose();
                        return;
                    } else {
                        JOptionPane.showMessageDialog(loginView, "Invalid Kitchen Credentials");
                        return;
                    }
                }

                // ================= CUSTOMER / DELIVERY LOGIN =================

                Users user = logindao.login(email, password, role);

                if (user != null) {
                    UserSession.login(user);

                    JOptionPane.showMessageDialog(loginView, "Login Successful!");

                    // ================= ROLE BASED REDIRECT =================
                    if (user.getRole().equals("DELIVERY")) {
                        DeliveryDash dd = new DeliveryDash();
                        DeliveryDashboardController controller = new DeliveryDashboardController(dd);
                        controller.open();
                    } else {
                        // CUSTOMER
                        MainPage mp = new MainPage();
                        MainPageController controller = new MainPageController(mp);
                        controller.open();
                        // restore cart logic
                        CartManager cart = CartManager.getCartForCurrentUser();
                        List<CartItem> savedItems = new CartDao().loadCart(user.getUser_id());

                        cart.clear();
                        savedItems.forEach(cart::addItem);

                    }

                    loginView.dispose();

                } else {
                    JOptionPane.showMessageDialog(loginView, "Invalid Email or Password");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

}
