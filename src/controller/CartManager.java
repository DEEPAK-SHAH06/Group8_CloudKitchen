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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import model.Users;
import utils.UserSession;
import view.CartPage;
import view.ProductCardPanel;

public class CartManager {

//    private CartPage cartpage;
    private static final Map<Integer, CartManager> userCarts = new HashMap<>();

    private final List<CartItem> items = new ArrayList<>();

    private CartManager() {}

    public static CartManager getCartForCurrentUser() {
        Users user = UserSession.getCurrentUser();

        if (user == null) {
            throw new IllegalStateException("User not logged in");
            //JOptionPane.showMessageDialog(cartpage, "User not logged in");
        }

        return userCarts.computeIfAbsent(
            user.getUser_id(),
            id -> new CartManager()
        );
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

    public void removeItem(int itemId) {
        items.removeIf(item -> item.getItemId() == itemId);
    }

    public List<CartItem> getItems() {
        return items;
    }

    public int getItemCount() {
        return items.stream().mapToInt(CartItem::getQuantity).sum();
    }

    public double getTotalAmount() {
        return items.stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }

    public void clear() {
        items.clear();
    }
}

