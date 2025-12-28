/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author deepakshah
 */
public class Item {
    
    private int item_id;
    private String itemName;
    private String category;
    private double price;
    private String imagePath;

    private String availability;

    public Item() {
       
    }

    
    public int getItem_id() {
        return item_id;
    }
    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availabiltiy) {
        this.availability = availability;
    }
    
////    public Availability getAvailability() {
////        return availability;
////    }
////    public void setAvailability(Availability availability) {
////        this.availability = availability;
////    }
////    public Item(String itemName, String category, double price, Item.Availability availability, String imagePath) {
////        this.itemName = itemName;
////        this.category = category;
////        this.price = price;
////        this.availability = availability;
////        this.imagePath = imagePath;
////    }
//    
    public Item(int item_id,String itemName, String category, double price, String imagePath, String availability) {
        this.item_id = item_id;
        this.itemName = itemName;
        this.category = category;
        this.price = price;
        this.imagePath = imagePath;
        this.availability = availability;
        
    }
    
    public Item(int item_id,String itemName, String category, double price, String imagePath) {
        this.item_id = item_id;
        this.itemName = itemName;
        this.category = category;
        this.price = price;
        this.imagePath = imagePath;
        
    }

}

