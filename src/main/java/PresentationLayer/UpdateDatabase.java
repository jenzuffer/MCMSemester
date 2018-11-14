/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mark
 */
public class UpdateDatabase extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        if (request.getParameter("productid") != null) {
            LogicFacade.updateProductOrAdd(Integer.valueOf(request.getParameter("productid")), request.getParameter("name"), Double.valueOf(request.getParameter("price")), request.getParameter("description"), Integer.valueOf(request.getParameter("length")), request.getParameter("unit"), request.getParameter("type"));
        }
        request.setAttribute("allproducts", LogicFacade.listOfAllMaterials());
        return "editproducts";
    }

}
