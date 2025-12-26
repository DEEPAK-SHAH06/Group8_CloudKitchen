/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author deepakshah
 */
public class CartItem {

    private int itemId;
    private String name;
    private double price;
    private String imagePath;
    private int quantity = 1;

    public CartItem(int itemId, String name, double price, String imagePath) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.imagePath = imagePath;
    }

    public int getItemId() { return itemId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getImagePath() { return imagePath; }
    public int getQuantity() { return quantity; }

    public void increaseQty() {
        quantity++;
    }

    public double getTotalPrice() {
        return price * quantity;
    }
}



