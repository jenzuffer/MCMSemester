/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author Christian
 */
public class LoginSampleException extends Exception {

    //måske Exception som parameter
    public LoginSampleException(String msg /*, Exception ex */) {
        //this.ex = ex;
        super(msg);
    }
}
