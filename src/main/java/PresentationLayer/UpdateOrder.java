/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.CarportDimensioner;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Christian
 */
public class UpdateOrder extends Command {

    public UpdateOrder() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        int width = Integer.valueOf(request.getParameter("width")) == null ? 0 : Integer.valueOf(request.getParameter("width"));
        int length = Integer.valueOf(request.getParameter("length")) == null ? 0 : Integer.valueOf(request.getParameter("length"));
        CarportDimensioner dimension = LogicFacade.createCarport(width, length);
        int Order = request.getSession().getAttribute("OrderID") == null ? 0 : (int) request.getSession().getAttribute("OrderID");
        dimension = LogicFacade.changeOrder(Order, dimension);
        session.setAttribute("dimension", dimension);
        return "orderupdateconfirmation";
    }

}
