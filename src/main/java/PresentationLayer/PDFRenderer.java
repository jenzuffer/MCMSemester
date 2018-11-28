/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Carport;
import FunctionLayer.LoginSampleException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        System.out.println(carport.getMaterials().size());
//        try {
//            PDFGenerator pdf = new PDFGenerator(carport);
//        } catch (IOException ex) {
//            System.out.println("Failed");
//        }
        return "renderpdf";
    }

}
