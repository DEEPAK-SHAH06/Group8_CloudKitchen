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

//    private static CartManager instance;
//    private final Map<Integer, CartItem> cartMap = new LinkedHashMap<>();
//
//    private CartManager() {}
//
//    public static CartManager getInstance() {
//        if (instance == null) {
//            instance = new CartManager();
//        }
//        return instance;
//    }
//
//    public void addItem(Item item) {
//        if (cartMap.containsKey(item.getItem_id())) {
//            cartMap.get(item.getItem_id()).increaseQty();
//        } else {
//            cartMap.put(
//                item.getItem_id(),
//                new CartItem(
//                    item.getItem_id(),
//                    item.getItemName(),
//                    item.getPrice(),
//                    item.getImagePath()
//                )
//            );
//        }
//    }
//
//    public Collection<CartItem> getItems() {
//        return cartMap.values();
//    }
//
//    public int getItemCount() {
//        return cartMap.values()
//                .stream()
//                .mapToInt(CartItem::getQuantity)
//                .sum();
//    }
//
//    public double getTotalAmount() {
//        return cartMap.values()
//                .stream()
//                .mapToDouble(CartItem::getTotalPrice)
//                .sum();
//    }
//
//    public void removeItem(int itemId) {
//        cartMap.remove(itemId);
//    }
//
//    public void clear() {
//        cartMap.clear();
//    }


private static CartManager instance;
    private final List<CartItem> items = new ArrayList<>();

    private CartManager() {}

    public static CartManager getInstance() {
        if (instance == null) instance = new CartManager();
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
    
 //   public void addItem(Item item) {
//        if (cartMap.containsKey(item.getItem_id())) {
//            cartMap.get(item.getItem_id()).increaseQty();
//        } else {
//            cartMap.put(
//                item.getItem_id(),
//                new CartItem(
//                    item.getItem_id(),
//                    item.getItemName(),
//                    item.getPrice(),
//                    item.getImagePath()
//                )
//            );
//        }
//    }

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


