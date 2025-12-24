/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AdminDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import model.Users;
import view.AdminDashboard1;
import view.AdminUsersTableModel;
import view.login;

/**
 *
 * @author deepakshah
 */
public class AdminDashboardController {
    
    private final AdminDao adminDao = new AdminDao();
    private  AdminDashboard1 ad1;
    private JTable table;
    private AdminUsersTableModel tableModel;
    private AdminDao dao = new AdminDao();
    
    public AdminDashboardController(AdminDashboard1 ad1){
        this.ad1 = ad1;
        ad1.logOutListener(new AddLogoutListener());
    }
    
    public void open(){
        this.ad1.setVisible(true);
    }
    public void close(){
        this.ad1.dispose();
    }

     class AddLogoutListener implements ActionListener {

        public AddLogoutListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            
             
             login lc = new login();
             LoginController log = new LoginController(lc);
             log.close();
             log.open();
             ad1.dispose();
            
        }
    }
    
}
