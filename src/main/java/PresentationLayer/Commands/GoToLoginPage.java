/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer.Commands;

import PresentationLayer.Commands.Command;
import FunctionLayer.Exceptions.DataException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Christian
 */
public class GoToLoginPage extends Command {
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DataException {
        if (request.getSession().getAttribute("user") != null) {
            //request.getSession().getAttribute("OrderList") != null
            User user = (User) request.getSession().getAttribute("user");
            if (user.getRole().equals("admin")) {
                return "employeepage";
            } else if (user.getRole().equals("customer")) {
                return "navigator";
            }
        }
        return "login";
    }
    
}
