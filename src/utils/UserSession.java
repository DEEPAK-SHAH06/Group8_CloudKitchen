/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author deepakshah
 */


import model.Users;

public class UserSession {

    private static Users loggedInUser = null;

    private UserSession() {}

    public static void login(Users user) {
        loggedInUser = user;
    }

    public static void logout() {
        loggedInUser = null;
    }

    public static boolean isLoggedIn() {
        return loggedInUser != null;
    }

    public static Users getUser() {
        return loggedInUser;
    }
    
    public static Users getCurrentUser() {
        return loggedInUser;
    }
    
    public static void setCurrentUser(Users user) {
        loggedInUser = user;
    }

    public static int getCustomerId() {
        return loggedInUser != null ? loggedInUser.getUser_id() : -1;
    }
    public static int getUserId() {
        return loggedInUser.getUser_id();
    }
    
    
    
    
}
