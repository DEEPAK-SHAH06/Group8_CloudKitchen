/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.LoginDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.OTPStore;
import view.ResetPassword;
import view.login;

/**
 *
 * @author deepakshah
 */
public class ResetPassController {

    private final ResetPassword rp;
    private final LoginDao logindao;
    private final String email; // ✅ stored properly

    public ResetPassController(ResetPassword rp, String email) {
        this.rp = rp;
        this.email = email;
        this.logindao = new LoginDao();
        rp.ResetButtonListener(new AddResetButtonListener());
    }

    public void open() {
        this.rp.setVisible(true);
    }

    public void close() {
        this.rp.dispose();
    }

    class AddResetButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String newPass = rp.getTxtNewPassword().getText().trim();
            String confirmPass = rp.getTxtConfirmPassword().getText().trim();

            if (newPass.isEmpty() || confirmPass.isEmpty()) {
                JOptionPane.showMessageDialog(rp, "Please fill all fields.");
                return;
            }

            if (!newPass.equals(confirmPass)) {
                JOptionPane.showMessageDialog(rp, "Passwords do not match.");
                return;
            }

            boolean updated = logindao.updatePassword(email, newPass);

            if (updated) {
                JOptionPane.showMessageDialog(rp, "Password reset successful!");
                new login().setVisible(true);
                rp.dispose();
            } else {
                JOptionPane.showMessageDialog(rp, "Something went wrong.");
            }
        }
    }
}
