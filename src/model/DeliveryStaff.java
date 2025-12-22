/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author deepakshah
 */
public class DeliveryStaff {
    
    private int deliveryStaff_id;
    private String deliveryStaff_name;
    private String deliveryStaff_email;
    private String deliveryStaff_password;
    private long phone;
    private String vehicleType;
    private Shift shift;

    public DeliveryStaff() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private enum Shift{
        MORNING, EVENING, NIGHT
    }

    public int getDeliveryStaff_id() {
        return deliveryStaff_id;
    }

    public void setDeliveryStaff_id(int deliveryStaff_id) {
        this.deliveryStaff_id = deliveryStaff_id;
    }

    public String getDeliveryStaff_name() {
        return deliveryStaff_name;
    }

    public void setDeliveryStaff_name(String deliveryStaff_name) {
        this.deliveryStaff_name = deliveryStaff_name;
    }

    public String getDeliveryStaff_email() {
        return deliveryStaff_email;
    }

    public void setDeliveryStaff_email(String deliveryStaff_email) {
        this.deliveryStaff_email = deliveryStaff_email;
    }

    public String getDeliveryStaff_password() {
        return deliveryStaff_password;
    }

    public void setDeliveryStaff_password(String deliveryStaff_password) {
        this.deliveryStaff_password = deliveryStaff_password;
    }
    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public DeliveryStaff(int deliveryStaff_id, String deliveryStaff_name, String deliveryStaff_email,
            String deliveryStaff_password, DeliveryStaff.Shift shift) {
        this.deliveryStaff_id = deliveryStaff_id;
        this.deliveryStaff_name = deliveryStaff_name;
        this.deliveryStaff_email = deliveryStaff_email;
        this.deliveryStaff_password = deliveryStaff_password;
        this.shift = shift;
    }


    

}

