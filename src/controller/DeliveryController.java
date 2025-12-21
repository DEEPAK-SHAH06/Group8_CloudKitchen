/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author deepakshah
 */


import dao.DeliveryDao;
import tablemodel.DeliveryTableModel;

public class DeliveryController {

    private final DeliveryDao dao = new DeliveryDao();
    private final DeliveryTableModel model;

    public DeliveryController(DeliveryTableModel model) {
        this.model = model;
    }

    public void loadStaff() {
        model.setStaff(dao.getAllStaff());
    }
}

