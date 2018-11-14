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
public class CalculateOrder extends Command {

    @Override
            
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        List<Materials> OrderMaterials = new ArrayList();
        int width = Integer.valueOf(request.getParameter("width")) == null ? 0 : Integer.valueOf(request.getParameter("width"));
        int length = Integer.valueOf(request.getParameter("length")) == null ? 0 : Integer.valueOf(request.getParameter("length"));
        CarportDimensioner dimension = new CarportDimensioner(length, width);
        int indexID = 1; //tilføj måde til at sige hvilken order vi taler om
        OrderMaterials = LogicFacade.calculateOrder(dimension, indexID);
        session.setAttribute("ordermaterials", OrderMaterials);
        return "customerconfirmation";
    }

}