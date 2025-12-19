/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ItemDao;
import java.util.List;
import javax.swing.JPanel;
import model.Item;
import view.ProductCardPanel;

/**
 *
 * @author deepakshah
 */
public class MainPageController {

    private ItemDao itemDao = new ItemDao();
    private JPanel panelProducts;

    public MainPageController(JPanel panelProducts) {
        this.panelProducts = panelProducts;
    }

    public void loadProducts() {

        panelProducts.removeAll();

        List<Item> items = itemDao.getAvailableItems();

        for (Item item : items) {
            ProductCardPanel card = new ProductCardPanel(item);
            panelProducts.add(card);
        }

        panelProducts.revalidate();
        panelProducts.repaint();
    }
}

