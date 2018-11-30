/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Christian
 */
public class GoToEmployeePage extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String Email = request.getParameter("email");
        String Pw = request.getParameter("firstpassword");
        boolean authenticated = LogicFacade.isAdmin(Email, Pw);
        request.getSession().setAttribute("admin", authenticated);
        if (authenticated) {
            List<Order> orderlist = LogicFacade.getOrderlist();
            request.setAttribute("OrderList", Pw);
            return "employeepage";
        }
        else
        {
            return "login";
        }
    }

}
