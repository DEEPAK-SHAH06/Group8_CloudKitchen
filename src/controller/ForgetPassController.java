/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URLEncoder;
import javax.swing.JOptionPane;
import model.OTPStore;
import view.OTPVerifyPage;
import view.forgetpass;

/**
 *
 * @author deepakshah
 */
public class ForgetPassController {
    
    private final forgetpass fgp;
           
    
    public ForgetPassController(forgetpass fgp){
        this.fgp = fgp;
        fgp.AddBtnSendCodeActionListener(new btnSendCodeListener());
    }

    class btnSendCodeListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           try {
               
            String email = fgp.getTxtEmail().getText().trim();
               
           
            String code = OTPStore.generateOTPAndSaveForEmail(email); // your OTP saving logic
            String resetLink = "http://your-app/reset?email=" + URLEncoder.encode(email, "UTF-8") + "&code=" + code;

            String subject = "Password reset code";
            String body = "Your reset code: " + code + "\nReset link: " + resetLink;

            utils.EmailSender.sendEmail(email, subject, body);
            JOptionPane.showMessageDialog(fgp, "Code sent. Check your email.");
            
            OTPVerifyPage ovp = new OTPVerifyPage();
            ovp.setVisible(true);
            
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(fgp, "Failed to send email: " + ex.getMessage());
        }
            }
        }
    
}
