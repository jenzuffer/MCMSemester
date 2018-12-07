/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer.Commands;

import PresentationLayer.Commands.Command;
import FunctionLayer.LogicFacade;
import FunctionLayer.Exceptions.DataException;
import FunctionLayer.Carport;
import FunctionLayer.Exceptions.OrderException;
import FunctionLayer.Exceptions.PDFException;
import FunctionLayer.User;
import PresentationLayer.Mail;
import PresentationLayer.Order;
import PresentationLayer.PDFGenerator;
import PresentationLayer.SVGofCarport;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.commons.mail.EmailException;

/**
 *
 * @author Christian
 */
public class UpdateOrder extends Command {

    public UpdateOrder() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DataException, OrderException, PDFException, EmailException {
        String x = request.getParameter("submit");
        int OrderID = Integer.valueOf(request.getParameter("OrderID"));
        List<Order> orderlist;
        
        if (x.equalsIgnoreCase("Delete Order")) {
            LogicFacade.deleteOrder(OrderID);
            orderlist = LogicFacade.getOrderlist();
            request.getSession().setAttribute("OrderList", orderlist);
            return "employeepage";
        }
        
        int width = Integer.valueOf(request.getParameter("width"));
        int length = Integer.valueOf(request.getParameter("length"));
        int shedwidth = Integer.valueOf(request.getParameter("shedwidth"));
        int shedlength = Integer.valueOf(request.getParameter("shedlength"));
        boolean roof = Boolean.valueOf(request.getParameter("roof"));
        boolean shed = Boolean.valueOf(request.getParameter("shed"));
        String name = request.getParameter("name");
        String adress = request.getParameter("adress");
        String city = request.getParameter("city");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String role = request.getParameter("role");
        if (x != null) {
            switch (x) {
                case "Edit Order": {
                    int customerID = Integer.valueOf(request.getParameter("customerid"));
                    int carportID = Integer.valueOf(request.getParameter("carportid"));
                    if (!request.getParameter("width").isEmpty() && !request.getParameter("length").isEmpty() && !request.getParameter("shedwidth").isEmpty()
                            && !request.getParameter("shedlength").isEmpty() && !request.getParameter("roof").isEmpty() && !request.getParameter("shed").isEmpty()) {
                        LogicFacade.editOrder(OrderID, customerID, carportID, name, adress, city, phone, email, role, width, length, shedwidth, shedlength, roof, shed);
                        orderlist = LogicFacade.getOrderlist();
                        request.getSession().setAttribute("OrderList", orderlist);
                        break;
                    }
                }
                case "View Order content": {
                    Carport carport = LogicFacade.calculateCarportList(new Carport(length, width, shedlength, shedwidth, shed, roof));
                    request.getSession().setAttribute("carport", carport);
                    return "itemlist";
                }
                case "pdfview": {
                try {
                    Carport cp = LogicFacade.calculateCarportList(new Carport(length, width, shedlength, shedwidth, shed, roof));
                    PDFGenerator pdfGen = new PDFGenerator(cp, new SVGofCarport().carport(cp, 230, 230));
                    byte[] pdf = pdfGen.generatePdf();
                    request.setAttribute("pdf", pdf);
                    request.getRequestDispatcher("/PDF").forward(request, response);
                    break;
                } catch (ServletException | IOException ex) {
                    Logger.getLogger(UpdateOrder.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                case "Send confirmation": {
                    Carport cp = LogicFacade.calculateCarportList(new Carport(length, width, shedlength, shedwidth, shed, roof));
                    PDFGenerator pdfGen = new PDFGenerator(cp, new SVGofCarport().carport(cp, 230, 230));
                    
                        byte[] pdf = pdfGen.generatePdf();
                        LogicFacade.inserPdf(OrderID, pdf);
                        new Mail(new User(name, adress, city, phone, email), pdf).sendEmailWithAttachtment();
                    break;
                }
            }
        }
        return "employeepage";
    }
}
