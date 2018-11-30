/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

/**
 *
 * @author Christian
 */
public class Order {

    private int orderID;
    private int customerID;
    private int carportID;
    private String name;
    private String address;
    private String city;
    private String phoneNumber;
    private String email;
    private String role;
    private int width;
    private int length;
    private int shedWidth;
    private int shedLength;
    private boolean roof;
    private boolean shed;

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getCarportID() {
        return carportID;
    }

    public void setCarportID(int carportID) {
        this.carportID = carportID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getShedWidth() {
        return shedWidth;
    }

    public void setShedWidth(int shedWidth) {
        this.shedWidth = shedWidth;
    }

    public int getShedLength() {
        return shedLength;
    }

    public void setShedLength(int shedLength) {
        this.shedLength = shedLength;
    }

    public boolean isRoof() {
        return roof;
    }

    public void setRoof(boolean roof) {
        this.roof = roof;
    }

    public boolean isShed() {
        return shed;
    }

    public void setShed(boolean shed) {
        this.shed = shed;
    }

    public Order(int orderID, int customerID, int carportID, String name, String address, String city, String phoneNumber, String email, String role, int width, int length, int shedWidth, int shedLength, boolean roof, boolean shed) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.carportID = carportID;
        this.name = name;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.role = role;
        this.width = width;
        this.length = length;
        this.shedWidth = shedWidth;
        this.shedLength = shedLength;
        this.roof = roof;
        this.shed = shed;
    }

}
