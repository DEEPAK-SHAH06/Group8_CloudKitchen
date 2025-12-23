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

    public MainPageController(MainPage mainpageview) {
        this.mainpageview = mainpageview;
        
        loadAllProducts();
    }
    
    public void open(){
        this.mainpageview.setVisible(true);
    }
    
    public void close(){
        this.mainpageview.dispose();
    }
    
    public void loadAllProducts(){
        List<Item> item = itemDao.getAllItems();
        JPanel panel = mainpageview.getItemPanel();
        
        panel.removeAll();
        
        for(Item it: item){
            ProductCardPanel card = new ProductCardPanel();
            card.loadData(it);
            panel.add(card);
        }
        
        panel.revalidate();
        panel.repaint();
    }
    
}

