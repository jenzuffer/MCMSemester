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
        int height = Integer.valueOf(request.getParameter("height")) == null ? 0 : Integer.valueOf(request.getParameter("height"));
        int width = Integer.valueOf(request.getParameter("width")) == null ? 0 : Integer.valueOf(request.getParameter("width"));
        int length = Integer.valueOf(request.getParameter("length")) == null ? 0 : Integer.valueOf(request.getParameter("length"));
        int polls = Integer.valueOf(request.getParameter("polls")) == null ? 0 : Integer.valueOf(request.getParameter("polls"));
        int spears = Integer.valueOf(request.getParameter("rafter")) == null ? 0 : Integer.valueOf(request.getParameter("rafter"));
        CarportDimensioner dimension = LogicFacade.CreateCarport(height, width, length, polls, spears);
        int Order = request.getSession().getAttribute("OrderID") == null ? 0 : (int) request.getSession().getAttribute("OrderID");
        dimension = LogicFacade.ChangeOrder(Order, dimension);
        session.setAttribute("dimension", dimension);
        return "OrderUpdateConfirmation";
    }

}
