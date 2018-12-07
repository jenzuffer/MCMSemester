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
public class UserException extends Exception {

    /**
     * UserException to handle the UserMapper
     * @param message error message that is to be displayed
     */
    public UserException(String message) {
        super(message);
    }
    
}
