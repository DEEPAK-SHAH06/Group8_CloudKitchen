/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.OTPStore;
import view.OTPVerifyPage;
import view.ResetPassword;

/**
 *
 * @author deepakshah
 */
public class OTPVerifyController {

    private OTPVerifyPage ovp;
    private String email;

    public OTPVerifyController(OTPVerifyPage ovp, String email) {
        this.ovp = ovp;
        this.email = email;
        ovp.addVerifyListener(new VerifyListener());
    }

    class VerifyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Verify Button Clicked...");
            String enteredOtp = ovp.getTxtOTP().getText().trim();

            if (OTPStore.verifyOTP(email, enteredOtp)) {
                OTPStore.clearOTP(email);

                ResetPassword rp = new ResetPassword(email);
                ResetPassController con = new ResetPassController(rp, email);
                con.open();
                ovp.dispose();
            } else {
                JOptionPane.showMessageDialog(ovp, "Invalid OTP");
            }
        }
    }
}

