/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Exceptions.OrderException;
import FunctionLayer.User;
import PresentationLayer.Order;
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

     /**
     * Inserts a PDF based on DB OrderID
     *
     * @param orderId int to find order to insert pdf
     * @param pdf byte array containing pdf
     * @throws OrderException if query fails
     */
    public static void insertPdf(int orderId, byte[] pdf) throws OrderException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE `Order` SET `pdf` = ? WHERE (`OrderID` = ?);";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setBytes(1, pdf);
            ps.setInt(2, orderId);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException("Could not insert pdf " + ex.getMessage());
        }
    }

    /**
     * returns a list with Orders
     *
     * @return a list of Order
     * @throws OrderException if query fails
     */
    public static List<Order> getOrderList() throws OrderException {
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
            throw new OrderException("Failed retrieving orderlist" + ex.getMessage());
        }
        return orderlist;
    }

     /**
     * Deletes an Order from the DB
     *
     * @param OrderID int ID to delete Order with
     * @throws OrderException if query fails deleting
     */
    public static void deleteOrder(int OrderID) throws OrderException {
        String SQL = "delete from `Order` WHERE `OrderID`=" + OrderID;
        try {
            Connection l_cCon = Connector.connection();
            Statement l_pStatement = l_cCon.prepareStatement(SQL);
            l_pStatement.executeUpdate(SQL);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException("Could not delete order" + ex.getMessage());
        }
    }

    /**
     * Edites an Order from the DB
     *
     * @param OrderID int ID of Order
     * @param customerID int ID of customer
     * @param carportID int ID of Carport
     * @param name String name
     * @param adress String adress
     * @param city String city
     * @param phone String phone
     * @param email String email
     * @param role string role
     * @param width int width
     * @param length int length
     * @param shedwidth int shedwidth
     * @param shedlength int shedlength
     * @param roof boolean roof
     * @param shed boolean shed
     * @throws OrderException if query fails editing order
     */
    public static void editOrder(int OrderID, int customerID, int carportID, String name, String adress, String city, String phone, String email, String role, int width, int length, int shedwidth, int shedlength, boolean roof, boolean shed) throws OrderException {
        try {
            Connection l_cCon = Connector.connection();
            String SQL = "UPDATE `Customer` SET `Name` = ?, `Adress`= ?, `City`= ?,`Phonenumber`= ?, `Email`= ?, `Role`= ? WHERE `ID` = ?";
            PreparedStatement l_pStatement = l_cCon.prepareStatement(SQL);
            l_pStatement.setString(1, name);
            l_pStatement.setString(2, adress);
            l_pStatement.setString(3, city);
            l_pStatement.setString(4, phone);
            l_pStatement.setString(5, email);
            l_pStatement.setString(6, role);
            l_pStatement.setInt(7, customerID);
            l_pStatement.executeUpdate();
            SQL = "UPDATE `Carport` SET `Width`= ?,`Length`= ?,`ShedWidth`= ?,`ShedLength`= ?,`Roof`= ?,`Shed`= ? WHERE `idCarport`= ?";
            l_pStatement = l_cCon.prepareStatement(SQL);
            l_pStatement.setInt(1, width);
            l_pStatement.setInt(2, length);
            l_pStatement.setInt(3, shedwidth);
            l_pStatement.setInt(4, shedlength);
            l_pStatement.setBoolean(5, roof);
            l_pStatement.setBoolean(6, shed);
            l_pStatement.setInt(7, carportID);
            l_pStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException("Could not edit order: " + ex.getMessage());
        }
    }

    /**
     * Adds an Order to the DB
     *
     * @param user the customer related to an order
     * @param carportID the ID to specify what carport is related
     * @throws OrderException if query fails adding order
     */
    public static void addOrder(User user, int carportID) throws OrderException {
        String SQL = "INSERT INTO `Order` (`OrderID`,`customerID`,`idCarport`,`pdf`) VALUES (NULL, ?, ?, \"\")";
        try {
            Connection l_cCon = Connector.connection();
            PreparedStatement l_pStatement = l_cCon.prepareStatement(SQL);
            l_pStatement.setInt(1, user.getId());
            l_pStatement.setInt(2, carportID);
            l_pStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException("Could not add order: " + ex.getMessage() + " sql: " + SQL);
        }
    }
}
