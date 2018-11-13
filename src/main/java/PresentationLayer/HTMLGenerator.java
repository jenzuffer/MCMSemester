/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import java.util.List;

/**
 *
 * @author mwn
 */
public class HTMLGenerator {
    
    public String getDropdownFromList(List list, String unit) {
        StringBuilder sb = new StringBuilder();
        for (Object i : list) {
            sb.append("<option value=\"" + i + "\">" + i + unit + "</option>");
        }
        return sb.toString();
    }
    
}
