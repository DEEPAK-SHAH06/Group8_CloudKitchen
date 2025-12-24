/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Limbu Mbg Sujata
 */
public class DeliveryA {
	private final String staffName;
	private final String phone;
	private final String email;
	private final String password;
	private final String shift;
	private final String vehicleType;

	public DeliveryA(String staffName, String phone, String email, String password, String shift, String vehicleType) {
		this.staffName = staffName;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.shift = shift;
		this.vehicleType = vehicleType;
	}

	public String getStaffName() {
		return staffName;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getShift() {
		return shift;
	}

	public String getVehicleType() {
		return vehicleType;
	}
}
