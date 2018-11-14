/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Materiale;
import java.util.List;

/**
 *
 * @author mwn
 */
public class HTMLGenerator {

    public String getDropdownFromList(List list, String unit) {
        StringBuilder sb = new StringBuilder();
        for (Object object : list) {
            sb.append("<option value=").append(object).append(">").append(object).append(unit).append("</option>");
        }
        return sb.toString();
    }

    public String getTableFromList(List<Materiale> tableData) {
        StringBuilder sb = new StringBuilder();
        sb.append("  <thead>\n"
                + "    <tr>\n"
                + "      <th scope=\"col\">Name</th>\n"
                + "      <th scope=\"col\">Length</th>\n"
                + "      <th scope=\"col\">Pieces</th>\n"
                + "      <th scope=\"col\">Unit</th>\n"
                + "      <th scope=\"col\">Description</th>\n"
                + "    </tr>\n"
                + "  </thead>\n"
                + "  <tbody>");

        for (Materiale materiale : tableData) {
            sb.append("<tr><td>")
                    .append(materiale.getNavn())
                    .append("</td><td>")
                    .append(materiale.getLængde())
                    .append("</td><td>")
                    .append(materiale.getAntal())
                    .append("</td><td>")
                    .append(materiale.getEnhed())
                    .append("</td><td>")
                    .append(materiale.getBeskrivelse())
                    .append("</td>")
              .append("</tr>");
        }
        sb.append("</tbody>");
        
        return sb.toString();

    }
}
