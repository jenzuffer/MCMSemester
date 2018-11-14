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
                + "      <th scope=\"col\">Amount</th>\n"
                + "      <th scope=\"col\">Unit</th>\n"
                + "      <th scope=\"col\">Description</th>\n"
                + "    </tr>\n"
                + "  </thead>\n"
                + "  <tbody>");

        for (Materiale materiale : tableData) {
            sb.append("<tr><td>")
                    .append(materiale.getName())
                    .append("</td><td>")
                    .append(materiale.getLength())
                    .append("</td><td>")
                    .append(materiale.getAmount())
                    .append("</td><td>")
                    .append(materiale.getUnit())
                    .append("</td><td>")
                    .append(materiale.getDescription())
                    .append("</td>")
                    .append("</tr>");
        }
        sb.append("</tbody>");

        return sb.toString();
    }

    public String getDatabase(List<Materiale> tableData) {
        StringBuilder sb = new StringBuilder();
        sb.append("  <thead>\n"
                + "    <tr>\n"
                + "      <th scope=\"col\">Id</th>\n"
                + "      <th scope=\"col\">Name</th>\n"
                + "      <th scope=\"col\">Price</th>\n"
                + "      <th scope=\"col\">Description</th>\n"
                + "      <th scope=\"col\">Length</th>\n"
                + "      <th scope=\"col\">Unit</th>\n"
                + "      <th scope=\"col\">Type</th>\n"
                + "    </tr>\n"
                + "  </thead>\n"
                + "  <tbody>");

        for (Materiale materiale : tableData) {
            sb.append("<tr><td>")
                    .append(materiale.getId())
                    .append("</td><td>")
                    .append(materiale.getName())
                    .append("</td><td>")
                    .append(materiale.getPrice())
                    .append("</td><td>")
                    .append(materiale.getDescription())
                    .append("</td><td>")
                    .append(materiale.getLength())
                    .append("</td><td>")
                    .append(materiale.getUnit())
                    .append("</td><td>")
                    .append(materiale.getType())
                    .append("</td>")
                    .append("</tr>");
        }
        sb.append("</tbody>");

        return sb.toString();
    }
}
