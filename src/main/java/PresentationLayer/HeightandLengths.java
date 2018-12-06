/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.Exceptions.DataException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Christian
 */
public class HeightandLengths extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws DataException {
        List<Integer> width = LogicFacade.getWidth();
        List<Integer> length = LogicFacade.getLength();
        List<Integer> shedWidth = LogicFacade.getShedWidth();
        List<Integer> shedLength = LogicFacade.getShedLength();
        request.setAttribute("width", width);
        request.setAttribute("length", length);
        request.setAttribute("shedwidth", shedWidth);
        request.setAttribute("shedlength", shedLength);
        return "calculatematerials";
    }

}
