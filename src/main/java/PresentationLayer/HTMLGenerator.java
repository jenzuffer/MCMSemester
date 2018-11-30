/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Materiale;
import java.util.Collection;
import java.util.HashMap;
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

    public String getTableFromList(Collection<List<Materiale>> tableData) {
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

        HashMap<String, List<Materiale>> HM = new HashMap();
        Collection<List<Materiale>> materialeilist = HM.values();

        for (List<Materiale> list : tableData) {
            for (Materiale materiale : list) {
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

    public String getOrders(List<Order> tableData) {
        StringBuilder sb = new StringBuilder();
        sb.append("  <thead>\n"
                + "    <tr>\n"
                + "      <th scope=\"col\">orderID</th>\n"
                + "      <th scope=\"col\">customerID</th>\n"
                + "      <th scope=\"col\">carportID</th>\n"
                + "      <th scope=\"col\">Name</th>\n"
                + "      <th scope=\"col\">Adress</th>\n"
                + "      <th scope=\"col\">City</th>\n"
                + "      <th scope=\"col\">Phonenumber</th>\n"
                + "      <th scope=\"col\">Email</th>\n"
                + "      <th scope=\"col\">Role</th>\n"
                + "      <th scope=\"col\">Width</th>\n"
                + "      <th scope=\"col\">Length</th>\n"
                + "      <th scope=\"col\">ShedWidth</th>\n"
                + "      <th scope=\"col\">ShedLength</th>\n"
                + "      <th scope=\"col\">Roof</th>\n"
                + "      <th scope=\"col\">Shed</th>\n"
                + "    </tr>\n"
                + "  </thead>\n"
                + "  <tbody>");

        for (Order order : tableData) {
            sb.append("<tr><td>")
                    .append(order.getOrderID())
                    .append("</td><td>")
                    .append(order.getCustomerID())
                    .append("</td><td>")
                    .append(order.getCarportID())
                    .append("</td><td>")
                    .append(order.getName())
                    .append("</td><td>")
                    .append(order.getAddress())
                    .append("</td><td>")
                    .append(order.getCity())
                    .append("</td><td>")
                    .append(order.getPhoneNumber())
                    .append("</td><td>")
                    .append(order.getEmail())
                    .append("</td><td>")
                    .append(order.getRole())
                    .append("</td><td>")
                    .append(order.getWidth())
                    .append("</td><td>")
                    .append(order.getLength())
                    .append("</td><td>")
                    .append(order.getShedWidth())
                    .append("</td><td>")
                    .append(order.getShedLength())
                    .append("</td><td>")
                    .append(order.isRoof())
                    .append("</td><td>")
                    .append(order.isShed())
                    .append("</td><td>");
        }
        sb.append("</tbody>");

        return sb.toString();
    }
}
