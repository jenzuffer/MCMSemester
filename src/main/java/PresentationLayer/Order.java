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

    public Order(int orderID, int customerID, int carportID) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.carportID = carportID;
    }
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

}
