/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author deepakshah
 */
public class Session {
    private static int userId;
    private static String username;
    private static long phone;
    private static int customerId;

    public static void setUser(int userId, int customerId, String username, long phone) {
        Session.userId = userId;
        Session.customerId = customerId;
        Session.username = username;
        Session.phone = phone;
    }

    public static int getUserId() { return userId; }
    public static int getCustomerId() { return customerId; }
    public static String getUsername() { return username; }
    public static long getPhone() { return phone; }
    
    
    
}
