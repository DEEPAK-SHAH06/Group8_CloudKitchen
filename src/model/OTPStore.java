/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author deepakshah
 */
//public class OTPStore {
//    public static int currentOTP;
//    public static String email;
//}



import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class OTPStore {

    public static int currentOTP;
    public static String email;

    private static final Map<String, String> otpMap = new HashMap<>();
    private static final Random random = new Random();

    // Generate OTP and save for email
    public static String generateOTPAndSaveForEmail(String email) {
        String otp = String.format("%06d", random.nextInt(999999));
        otpMap.put(email, otp);
        System.out.println("Generated OTP for " + email + ": " + otp);
        return otp;
    }

    // Get saved OTP
    public static String getOTP(String email) {
        return otpMap.get(email);
    }

    // Verify OTP
    public static boolean verifyOTP(String email, String enteredOtp) {
        String savedOtp = otpMap.get(email);
        return savedOtp != null && savedOtp.equals(enteredOtp);
    }

    // Remove OTP once used
    public static void clearOTP(String email) {
        otpMap.remove(email);
    }
}


