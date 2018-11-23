/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Carport;
import FunctionLayer.LogicFacade;
import FunctionLayer.Materiale;
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
        List<Materiale> OrderMaterials;
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String number = (request.getParameter("pnumber"));
        String email = request.getParameter("email");
        try {
            if (!name.isEmpty() && !address.isEmpty() && !city.isEmpty() && !number.isEmpty() && !email.isEmpty()) {
                LogicFacade.createCustomer(name, address, city, number, email);
            }
        } catch(NullPointerException e) {
            
        }
        int width = Integer.valueOf(request.getParameter("width")) == null ? 0 : Integer.valueOf(request.getParameter("width"));
        int length = Integer.valueOf(request.getParameter("length")) == null ? 0 : Integer.valueOf(request.getParameter("length"));
        int shedWidth = request.getParameter("shedwidth").contains("Choose") ? 0 : Integer.valueOf(request.getParameter("shedwidth"));
        int shedLength = request.getParameter("shedlength").contains("Choose") ? 0 : Integer.valueOf(request.getParameter("shedlength"));
        Carport carport = LogicFacade.calculateCarportList(new Carport(length, width, shedLength, shedWidth, true, true));
        
        request.setAttribute("carport", carport);
        // session.setAttribute("ordermaterials", OrderMaterials);
        //return "customerconfirmation";
        return "itemlist";
    }

}
