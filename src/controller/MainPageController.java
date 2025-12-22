/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ItemDao;
import java.util.List;
import javax.swing.JPanel;
import model.Item;
import view.MainPage;
import view.ProductCardPanel;

/**
 *
 * @author deepakshah
 */
public class MainPageController {

    private final ItemDao itemDao = new ItemDao();
    private JPanel panelProducts;
    private Item selectedItemForEdit = null;
    
    private MainPage mainpageview;

    public MainPageController(JPanel panelProducts) {
        this.panelProducts = panelProducts;
    }
    
    public void open(){
        this.mainpageview.setVisible(true);
    }
    
    public void close(){
        this.mainpageview.dispose();
    }

    public void loadProducts() {

        panelProducts.removeAll();

        List<Item> items = itemDao.getAllItems();

        for (Item item : items) {
            ProductCardPanel card = new ProductCardPanel();
            
            panelProducts.add(card);
            
            card.getEditButton().addActionListener(e -> {
                selectedItemForEdit = card.getCurrentProduct();
                //mainpageview
//                selectedProductForEdit = card.getCurrentProduct();
//            dashboardView.getProductName().setText(selectedProductForEdit.getProductName());
//            dashboardView.getProductPrice().setText(String.valueOf(selectedProductForEdit.getProductPrice()));
//            dashboardView.getProductImage().setText(selectedProductForEdit.getProductImage());
//            dashboardView.getAddButton().setText("Update Product");
            
            });
            
            panelProducts.add(card);
        }

        panelProducts.revalidate();
        panelProducts.repaint();
    }
    
    
    
}

