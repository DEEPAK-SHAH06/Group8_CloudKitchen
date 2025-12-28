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

    private static final Map<String, String> otpMap = new HashMap<>();

    public static String generateOTPAndSaveForEmail(String email) {
        String otp = String.valueOf(100000 + new Random().nextInt(900000));
        otpMap.put(email, otp);
        return otp;
    }

    public static boolean verifyOTP(String email, String enteredOtp) {
        return otpMap.containsKey(email) &&
               otpMap.get(email).equals(enteredOtp);
    }

    public static void clearOTP(String email) {
        otpMap.remove(email);
    }
}



