/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import PresentationLayer.Order;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mwn
 */
public class OrderMapper {

    public static void insertPdf(int orderId, byte[] pdf) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE `Order` SET `pdf` = ? WHERE (`OrderID` = ?);";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setBytes(1, pdf);
            ps.setInt(2, orderId);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException("Could not insert pdf " + ex.getMessage());
        }
    }

    public static List<Order> getOrderList() throws LoginSampleException, ClassNotFoundException {
        List<Order> orderlist = new ArrayList();
        String SQL = "SELECT Name, Adress, City, Phonenumber, Email, Role, OrderID,"
                + " customerID, c1.idCarport, Width, Length, ShedWidth, ShedLength, Roof, Shed FROM `Customer` m1,"
                + " `Carport` c1, `Order` o1 WHERE m1.ID = o1.customerID AND c1.idCarport = o1.idCarport";
        try {
            Connection l_cCon = Connector.connection();
            Statement l_pStatement = l_cCon.prepareStatement(SQL);
            ResultSet l_rsSearch = l_pStatement.executeQuery(SQL);
            while (l_rsSearch.next()) {
                Order order = new Order(l_rsSearch.getInt("OrderID"), l_rsSearch.getInt("customerID"), l_rsSearch.getInt("idCarport"),
                        l_rsSearch.getString("Name"), l_rsSearch.getString("Adress"), l_rsSearch.getString("City"), l_rsSearch.getString("Phonenumber"),
                        l_rsSearch.getString("Email"), l_rsSearch.getString("Role"), l_rsSearch.getInt("Width"), l_rsSearch.getInt("Length"), l_rsSearch.getInt("ShedWidth"),
                        l_rsSearch.getInt("ShedLength"), l_rsSearch.getBoolean("Roof"), l_rsSearch.getBoolean("Shed"));
                orderlist.add(order);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException("Could not insert pdf" + ex.getMessage());
        }
        return orderlist;
    }
}
