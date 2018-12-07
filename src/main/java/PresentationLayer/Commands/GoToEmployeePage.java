/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer.Commands;

import PresentationLayer.Commands.Command;
import FunctionLayer.LogicFacade;
import FunctionLayer.Exceptions.DataException;
import FunctionLayer.Exceptions.OrderException;
import FunctionLayer.Exceptions.UserException;
import FunctionLayer.User;
import PresentationLayer.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Christian
 */
public class GoToEmployeePage extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DataException, UserException, OrderException {
        if (request.getParameter("email") != null && request.getParameter("firstpassword") != null) {
            String Email = request.getParameter("email");
            String Pw = request.getParameter("firstpassword");
            request.getSession().setAttribute("email", Email);
            request.getSession().setAttribute("pw", Pw);
        }
        String Email = (String) request.getSession().getAttribute("email");
        String Pw = (String) request.getSession().getAttribute("pw");
        User user = LogicFacade.isUser(Email, Pw);
        if (user == null) {
            return "login";
        }
        request.getSession().setAttribute("user", user);
        boolean authenticated = LogicFacade.isAdmin(Email, Pw);
        request.getSession().setAttribute("admin", authenticated);
        if (authenticated) {
            List<Order> orderlist;
            orderlist = LogicFacade.getOrderlist();
            request.getSession().setAttribute("OrderList", orderlist);
            return "employeepage";
        } else {
            return "navigator";
        }
    }

}
