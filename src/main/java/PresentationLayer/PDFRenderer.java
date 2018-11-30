/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Carport;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mwn
 */
public class PDFRenderer extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        Carport carport = (Carport) request.getSession().getAttribute("carport");
        PDFGenerator pdfGen = new PDFGenerator(carport);
        try {
            byte[] pdf = pdfGen.generatePdf();
            LogicFacade.inserPdf(1, pdf);
            request.setAttribute("pdf", pdf);
            request.getRequestDispatcher("/PDF").forward(request, response);
        } catch (IOException ex) {
            System.out.println("Failed");
        } catch (ServletException ex) {
            System.out.println("Servlet exception");
        }
        return "itemlist";
    }

}
