/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer.Exceptions;

/**
 *
 * @author Christian
 */
public class DataException extends Exception {

    /**
     * DataException to handle the DataMapper
     * @param msg error message that is to be displayed
     */
    public DataException(String msg /*, Exception ex */) {
        //this.ex = ex;
        super(msg);
    }
}
