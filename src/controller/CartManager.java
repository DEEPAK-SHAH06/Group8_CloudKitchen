/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.CartItem;
import model.Item;

/**
 *
 * @author deepakshah
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import view.ProductCardPanel;

public class CartManager {

    private static CartManager instance;
    private final List<CartItem> items = new ArrayList<>();

    private CartManager() {
    }

    public static CartManager getInstance() {
        if (instance == null)
            instance = new CartManager();
        return instance;
    }

    public void addItem(CartItem newItem) {
        for (CartItem item : items) {
            if (item.getItemId() == newItem.getItemId()) {
                item.increaseQty();
                return;
            }
        }
        items.add(newItem);
    }

    public List<CartItem> getItems() {
        return items;
    }

    public int getItemCount() {
        return items.size();
    }

    public double getTotalAmount() {
        return items.stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }

    public void clear() {
        items.clear();
    }

    public void removeItem(int itemId) {
        items.remove(itemId);
    }
}
