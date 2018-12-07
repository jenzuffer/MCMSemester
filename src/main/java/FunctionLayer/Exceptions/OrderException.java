/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer.Exceptions;

/**
 *
 * @author mwn
 */
public class OrderException extends Exception {

    /**
     * OrderException to handle the OrderMapper
     * @param msg error message that is to be displayed
     */
    public OrderException(String msg /*, Exception ex */) {
        //this.ex = ex;
        super(msg);
    }
}
