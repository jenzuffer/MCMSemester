/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.Material;
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

    public String getTableFromList(Collection<List<Material>> tableData) {
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

        HashMap<String, List<Material>> HM = new HashMap();
        Collection<List<Material>> materialeilist = HM.values();

        for (List<Material> list : tableData) {
            for (Material materiale : list) {
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

    public String getDatabase(List<Material> tableData) {
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

        for (Material materiale : tableData) {
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

    public String getOrders(List<Order> data) {
        StringBuilder sb = new StringBuilder();
        sb.append("  <thead>\n"
                + "    <tr>\n"
                + "      <th scope=\"col\">Order ID</th>\n"
                + "      <th scope=\"col\">Name</th>\n"
                + "      <th scope=\"col\">Adress</th>\n"
                + "      <th scope=\"col\">City</th>\n"
                + "      <th scope=\"col\">Phonenumber</th>\n"
                + "      <th scope=\"col\">Email</th>\n"
                + "      <th scope=\"col\">Order options</th>\n"
                + "    </tr>\n"
                + "  </thead>\n"
                + "  <tbody>");

        for (Order order : data) {
            sb.append("<tr><td>")
                    .append(order.getOrderID())
                    .append("</td><td>")
                    .append(order.getName())
                    .append("</td><td>")
                    .append(order.getAdress())
                    .append("</td><td>")
                    .append(order.getCity())
                    .append("</td><td>")
                    .append(order.getPhoneNumber())
                    .append("</td><td>")
                    .append(order.getEmail())
                    .append("</td><td>")
                    .append("<div class=\"btn-group\" role=\"group\">")
                    .append("<form action=\"FrontController\" method=\"post\">")
                    .append("<button type=\"submit\" class=\"btn btn-info\"><i class=\"fas fa-folder-open\"></i></button>\n")
                    .append("<input type=\"hidden\" name=\"command\" value=\"showorder\">")
                    .append("<input type=\"hidden\" name=\"orderid\" value=\"")
                    .append(order.getOrderID())
                    .append("\">")
                    .append("</form>")
                    .append("<form action=\"FrontController\" method=\"post\">")
                    .append("<button type=\"submit\" class=\"btn btn-danger\"><i class=\"far fa-trash-alt\"></i></button>\n")
                    .append("</form>")
                    .append("</div>")
                    .append("</td>")
                    .append("</tr>");
        }
        sb.append("</tbody>");
        sb.append("</tbody>");
        return sb.toString();
    }

    /*
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
            sb.append("<form action=\"FrontController\" method=\"post\">"
                    + "<div class=\"form-group\">\n");
            sb.append("<div>");
            sb.append("<tr><td>").append("").append(order.getOrderID())
                    .append("</td><td>").append("").append(order.getCustomerID())
                    .append("</td><td>").append("").append(order.getCarportID())
                    .append("</td><td>").append("<input type=\"text\" name=\"name\" value=\"").append(order.getName())
                    .append("\">")
                    .append("</td><td>").append("<input type=\"text\" name=\"adress\" value=\"").append(order.getAdress())
                    .append("\">")
                    .append("</td><td>").append("<input type=\"text\" name=\"city\" value=\"").append(order.getCity())
                    .append("\">")
                    .append("</td><td>").append("<input type=\"text\" name=\"phone\" value=\"").append(order.getPhoneNumber())
                    .append("\">")
                    .append("</td><td>").append("<input type=\"text\" name=\"email\" value=\"").append(order.getEmail())
                    .append("\">")
                    .append("</td><td>").append("<input type=\"text\" name=\"role\" value=\"").append(order.getRole())
                    .append("\">")
                    .append("</td><td>").append("<input type=\"text\" name=\"width\" value=\"").append(order.getWidth())
                    .append("\">")
                    .append("</td><td>").append("<input type=\"text\" name=\"length\" value=\"").append(order.getLength())
                    .append("\">")
                    .append("</td><td>").append("<input type=\"text\" name=\"shedwidth\" value=\"").append(order.getShedWidth())
                    .append("\">")
                    .append("</td><td>").append("<input type=\"text\" name=\"shedlength\" value=\"").append(order.getShedLength())
                    .append("\">")
                    .append("</td><td>").append("<input type=\"text\" name=\"roof\" value=\"").append(order.isRoof())
                    .append("\">")
                    .append("</td><td>").append("<input type=\"text\" name=\"shed\" value=\"").append(order.isShed())
                    .append("\">")
                    .append("</td><td>");
            sb.append("                            \n"
                    + "                          <input type=\"submit\" name =\"submit\" class=\"btn btn-primary\" value=\"Edit Order\">\n"
                    + "                          \n"
                    + "                          <input type=\"submit\" name =\"submit\" class=\"btn btn-primary\" value=\"View Order content\">\n"
                    + "                          \n"
                    + "                          <input type=\"submit\" name =\"submit\" class=\"btn btn-primary\" value=\"Delete Order\">");
            sb.append(" <input type=\"hidden\" name=\"OrderID\" value=").append(order.getOrderID()).append(">");
            sb.append(" <input type=\"hidden\" name=\"customerid\" value=").append(order.getCustomerID()).append(">");
            sb.append(" <input type=\"hidden\" name=\"carportid\" value=").append(order.getCarportID()).append(">");
            sb.append("</div>");
            sb.append("<input type=\"hidden\" name=\"command\" value=\"UpdateOrder\">\n  </form>");
        }
        
        sb.append("</tbody>");
        return sb.toString();
    }
     */
}
