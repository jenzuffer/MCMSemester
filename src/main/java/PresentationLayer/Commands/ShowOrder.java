/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer.Commands;

import FunctionLayer.Exceptions.DataException;
import FunctionLayer.Exceptions.OrderException;
import FunctionLayer.Exceptions.UserException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mwn
 */
public class ShowOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DataException, OrderException, UserException {
        return "detailedorder";
    }
    
}
