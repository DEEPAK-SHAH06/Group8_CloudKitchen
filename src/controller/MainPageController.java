/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ItemDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Item;
import utils.UserSession;
import view.MainPage;
import view.ProductCardPanel;
import view.SignUp;
import view.login;

/**
 *
 * @author deepakshah
 */
public class MainPageController {

    private final ItemDao itemDao = new ItemDao();
    private ItemController controller;
    private JPanel panelProducts;
    private Item selectedItemForEdit = null;

    private MainPage mainpageview;

    public MainPageController(MainPage mainpageview) {
        this.mainpageview = mainpageview;
        mainpageview.searchBtnListener(new searchListener());
        mainpageview.categoryComboListener(new categoryListener());
        mainpageview.LogoutListener(new addLogoutListener());
        mainpageview.loginListener(new addLoginListener());
        loadAllProducts();
    }

    public void open() {
        this.mainpageview.setVisible(true);
    }

    public void close() {
        this.mainpageview.dispose();
    }

    public void loadAllProducts() {
        List<Item> item = itemDao.getAllItems();
        JPanel panel = mainpageview.getItemPanel();

        panel.removeAll();

        for (Item it : item) {
            ProductCardPanel card = new ProductCardPanel();
            card.loadData(it);
            panel.add(card);
        }

        panel.revalidate();
        panel.repaint();
    }

    public void loadProducts(List<Item> items) {
        JPanel panel = mainpageview.getItemPanel();

        panel.removeAll();

        for (Item it : items) {
            ProductCardPanel card = new ProductCardPanel();
            card.loadData(it);
            panel.add(card);
        }

        panel.revalidate();
        panel.repaint();
    }

    public List<Item> searchItems(String keyword) {
        return itemDao.searchItems(keyword);
    }

    // logic to load products based on category
    public void loadProductsByCategory(String category) {
        List<Item> itemsByCategory = itemDao.getItemsByCategory(category);
        JPanel panel = mainpageview.getItemPanel();

        panel.removeAll();

        for (Item it : itemsByCategory) {
            ProductCardPanel card = new ProductCardPanel();
            card.loadData(it);
            panel.add(card);
        }

        panel.revalidate();
        panel.repaint();
    }

    class addLogoutListener implements ActionListener {

        public addLogoutListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            UserSession.logout();
            JOptionPane.showMessageDialog(mainpageview, "Logged out successfully");
            mainpageview.updateHeader();
        }
    }

    private static class addLoginListener implements ActionListener {

        public addLoginListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            login lc = new login();
            LoginController log = new LoginController(lc);
            log.close();
            log.open();
        }
    }

    class searchListener implements ActionListener {

        public searchListener() {
        }

        // In actionPerformed, add a debug print:
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Search button clicked"); // Debug line
            try {
                String keyword = mainpageview.getSearchField().getText().trim();
                if (!keyword.isEmpty()) {
                    loadProducts(searchItems(keyword));
                } else {
                    loadAllProducts();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    class categoryListener implements ActionListener {

        public categoryListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String category = mainpageview.getCategoryCombo().getSelectedItem().toString();

                if (category.equals("Categories")) {
                    loadAllProducts();
                } else {
                    loadProductsByCategory(category);
                }
            } catch (Exception ex) {
                System.out.println("Search Error: " + ex.getMessage());
            }
        }
    }

}
