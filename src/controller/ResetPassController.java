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
    private LoginDao logindao;
    
    public ResetPassController(ResetPassword rp){
        this.rp = rp;
        rp.ResetButtonListener(new AddResetButtonListener());
    }

    class AddResetButtonListener implements ActionListener {

        public AddResetButtonListener() {
        }

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

            boolean updated = logindao.updatePassword(OTPStore.email, newPass);

            if (updated) {
                JOptionPane.showMessageDialog(rp, "Password reset successful!");

                login lg = new login();
                lg.setVisible(true);
                rp.dispose();
            } else {
                JOptionPane.showMessageDialog(rp, "Something went wrong. Try again.");
            }
        }
    }
    
}
