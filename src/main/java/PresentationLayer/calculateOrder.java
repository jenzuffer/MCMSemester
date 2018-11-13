/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.CarportDimensioner;
import FunctionLayer.LogicFacade;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Christian
 */
public class calculateOrder extends Command {

    @Override
            
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        List<Materials> OrderMaterials = new ArrayList();
        int height = Integer.valueOf(request.getParameter("height")) == null ? 0 : Integer.valueOf(request.getParameter("height"));
        int width = Integer.valueOf(request.getParameter("width")) == null ? 0 : Integer.valueOf(request.getParameter("width"));
        int length = Integer.valueOf(request.getParameter("length")) == null ? 0 : Integer.valueOf(request.getParameter("length"));
        int polls = Integer.valueOf(request.getParameter("polls")) == null ? 0 : Integer.valueOf(request.getParameter("polls"));
        int spears = Integer.valueOf(request.getParameter("rafter")) == null ? 0 : Integer.valueOf(request.getParameter("rafter"));
        CarportDimensioner dimension = new CarportDimensioner(height, length, width, polls, spears);
        int indexID = 1; //tilføj måde til at sige hvilken order vi taler om
        OrderMaterials = LogicFacade.CalculateOrder(dimension, indexID);
        session.setAttribute("ordermaterials", OrderMaterials);
        return "customerconfirmation";
    }

}
