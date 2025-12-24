/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AddDeliveryDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.DeliveryA;
import view.Adddeliveryperson;



/**
 *
 * @author Limbu Mbg Sujata
 */
public class AddDeliveryController {
	private final Adddeliveryperson view;
	private final AddDeliveryDao dao;

	public AddDeliveryController(Adddeliveryperson view) {
		this.view = view;
		this.dao = new AddDeliveryDao();

		this.view.getAddButton().addActionListener(new AddButtonListener());
	}

	private class AddButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String staffName = view.getStaffName().getText();
			String phone = view.getPhone().getText();
			String email = view.getEmail().getText();
			String password = view.getPassword().getText();
			String shift = view.getShift().getText();
			String vehicleType = view.getVehicleType().getText();

			if (staffName.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty() || shift.isEmpty() || vehicleType.isEmpty()) {
				JOptionPane.showMessageDialog(view, "All fields are required");
				return;
			}

			DeliveryA delivery = new DeliveryA(staffName, phone, email, password, shift, vehicleType);

			if (dao.addDelivery(delivery)) {
				JOptionPane.showMessageDialog(view, "Delivery staff added successfully");
				view.getStaffName().setText("");
				view.getPhone().setText("");
				view.getEmail().setText("");
				view.getPassword().setText("");
				view.getShift().setText("");
				view.getVehicleType().setText("");
			} else {
				JOptionPane.showMessageDialog(view, "Failed to add delivery staff");
			}
		}
	}
}


