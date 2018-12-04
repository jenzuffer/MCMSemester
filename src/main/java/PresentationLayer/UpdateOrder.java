/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Carport;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Christian
 */
public class UpdateOrder extends Command {

    public UpdateOrder() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String x = request.getParameter("submit");
        int OrderID = Integer.valueOf(request.getParameter("OrderID"));
        int width = Integer.valueOf(request.getParameter("width"));
        int length = Integer.valueOf(request.getParameter("length"));
        int shedwidth = Integer.valueOf(request.getParameter("shedwidth"));
        int shedlength = Integer.valueOf(request.getParameter("shedlength"));
        boolean roof = Boolean.valueOf(request.getParameter("roof"));
        boolean shed = Boolean.valueOf(request.getParameter("shed"));
        try {
            List<Order> orderlist;
            if (x != null) {
                switch (x) {
                    case "Edit Order": {
                        int customerID = Integer.valueOf(request.getParameter("customerid"));
                        int carportID = Integer.valueOf(request.getParameter("carportid"));
                        String name = request.getParameter("name");
                        String adress = request.getParameter("adress");
                        String city = request.getParameter("city");
                        String phone = request.getParameter("phone");
                        String email = request.getParameter("email");
                        String role = request.getParameter("role");
                        if (!request.getParameter("width").isEmpty() && !request.getParameter("length").isEmpty() && !request.getParameter("shedwidth").isEmpty()
                                && !request.getParameter("shedlength").isEmpty() && !request.getParameter("roof").isEmpty() && !request.getParameter("shed").isEmpty()) {
                            LogicFacade.editOrder(OrderID, customerID, carportID, name, adress, city, phone, email, role, width, length, shedwidth, shedlength, roof, shed);
                            orderlist = LogicFacade.getOrderlist();
                            request.getSession().setAttribute("OrderList", orderlist);
                            break;
                        }
                    }
                    case "Delete Order": {
                        LogicFacade.deleteOrder(OrderID);
                        orderlist = LogicFacade.getOrderlist();
                        request.getSession().setAttribute("OrderList", orderlist);
                        break;
                    }
                    case "View Order content": {
                        
                        Carport carport = LogicFacade.calculateCarportList(new Carport(length, width, shedlength, shedwidth, shed, roof));
                        request.getSession().setAttribute("carport", carport);
                        return "itemlist";
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            throw new LoginSampleException("Failed Handling Order: " + ex.getMessage());
        }
        return "employeepage";
    }
}
