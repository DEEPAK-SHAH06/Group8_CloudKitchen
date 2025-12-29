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
import utils.PasswordUtil;
import utils.UserSession;
import utils.ValidationUtil;
import view.MainPage;
import view.SignUp;
import view.login;

/**
 *
 * @author deepakshah
 */
public class UserController {

    private final SignUpDao signupdao = new SignUpDao();
    private final LoginDao logindao = new LoginDao(); // ✅ FIX HERE
    private final SignUp userView;

    public UserController(SignUp userView) {
        this.userView = userView;
        userView.AddUserListener(new AddActionListener());
    }

    public void open() {
        this.userView.setVisible(true);
    }

    public void close() {
        this.userView.dispose();
    }

    class AddActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ex) {

            try {
                String username = userView.getUsernameText().getText().trim();
                String email = userView.getEmailText().getText().trim();
                String password = new String(userView.getPasswordText().getPassword());

                // ================= VALIDATIONS =================

                if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(userView, "All fields are required");
                    return;
                }

                // ✅ EMAIL FORMAT CHECK
                if (!ValidationUtil.isValidEmail(email)) {
                    JOptionPane.showMessageDialog(
                        userView,
                        "Please enter a valid email (example: user@gmail.com)"
                    );
                    return;
                }

                // ✅ EMAIL DUPLICATE CHECK
                if (logindao.emailExists(email)) {
                    JOptionPane.showMessageDialog(userView, "Email already registered");
                    return;
                }

                // ================= PASSWORD HASH =================
                String hashedPassword = PasswordUtil.hashPassword(password);

                Users users = new Users(username, email, hashedPassword);

                signupdao.signUp(users);

                // 🔥 AUTO LOGIN
                UserSession.setCurrentUser(users);

                JOptionPane.showMessageDialog(
                    userView,
                    "Signup successful! Logged in automatically"
                );

                MainPage main = new MainPage();
                new MainPageController(main).open();
                close();

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(userView, "Signup failed");
            }
        }
    }
}

