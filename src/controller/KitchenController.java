/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author deepakshah
 */


import dao.KitchenDao;
import model.Kitchen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import tablemodel.KitchenTableModel;

public class KitchenController {

    private final KitchenDao kitchenDao;
    private final JTable kitchenTable;

    public KitchenController(JTable kitchenTable) {
        this.kitchenTable = kitchenTable;
        this.kitchenDao = new KitchenDao();
    }
}

