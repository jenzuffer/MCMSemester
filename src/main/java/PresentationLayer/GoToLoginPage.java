/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Christian
 */
public class GoToLoginPage extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        if (request.getSession().getAttribute("admin") != null && request.getSession().getAttribute("OrderList") != null) {
            boolean admin = (boolean) request.getSession().getAttribute("admin");
            if (admin) {
                return "employeepage";
            }
        }
        return "login";
    }

}
