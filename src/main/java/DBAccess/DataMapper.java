/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Carport;
import FunctionLayer.Exceptions.DataException;
import FunctionLayer.Exceptions.OrderException;
import FunctionLayer.Material;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class DataMapper {

    /**
     * Returns a list of material objects. This method returns one or more
     * objects of a certain material, DEPRECATED
     *
     * @param indexID the id of a certain material
     * @return the List of materials
     * @throws DataException if query fails
     * @deprecated 
     */
    public static List<Material> calculateOrder(int indexID) throws DataException {
        List<Material> materials = new ArrayList();
        try {
            Connection l_cCon = Connector.connection();
            String l_sSQL = "SELECT * FROM `Materiale` WHERE id = " + indexID;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DataException(ex.getMessage());
        }
        return materials;
    }

    /**
     * Returns a list of integers. This method returns the possible widths of a
     * carport object
     * @throws DataException if query failed
     * @return the List of integers
     * 
     */
    public static List<Integer> getWidth() throws DataException {
        List<Integer> values = new ArrayList();
        try {
            Connection l_cCon = Connector.connection();

            String l_sSQL = "SELECT * FROM `width`";
            PreparedStatement l_pStatement = l_cCon.prepareStatement(l_sSQL);
            ResultSet l_rsSearch = l_pStatement.executeQuery();
            while (l_rsSearch.next()) {
                values.add(l_rsSearch.getInt(1));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DataException(ex.getMessage());
        }
        return values;
    }

    /**
     * Returns a list of integers. This method returns the possible lengths of a
     * carport object
     *
     * @return List of integers
     * @throws DataException if query fails
     */
    public static List<Integer> getLength() throws DataException {
        List<Integer> values = new ArrayList();
        try {
            Connection l_cCon = Connector.connection();
            String l_sSQL = "SELECT * FROM `length`";
            PreparedStatement l_pStatement = l_cCon.prepareStatement(l_sSQL);
            ResultSet l_rsSearch = l_pStatement.executeQuery();
            while (l_rsSearch.next()) {
                values.add(l_rsSearch.getInt(1));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DataException(ex.getMessage());
        }
        return values;
    }

    /**
     * Returns a list of integers. This method returns the possible widths of a
     * shed
     *
     * @return the List of integers
     * @throws DataException if query fails
     */
    public static List<Integer> getShedWidth() throws DataException {
        List<Integer> values = new ArrayList();
        try {
            Connection l_cCon = Connector.connection();

            String l_sSQL = "SELECT * FROM `ShedWidth`";
            PreparedStatement l_pStatement = l_cCon.prepareStatement(l_sSQL);
            ResultSet l_rsSearch = l_pStatement.executeQuery();
            while (l_rsSearch.next()) {
                values.add(l_rsSearch.getInt(1));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DataException(ex.getMessage());
        }
        return values;
    }

    /**
     * Returns a list of integers. This method returns the possible lengths of a
     * shed
     *
     * @return the List of integers
     * @throws DataException if query fails
     */
    public static List<Integer> getShedLength() throws DataException {
        List<Integer> values = new ArrayList();
        try {
            Connection l_cCon = Connector.connection();
            String l_sSQL = "SELECT * FROM `ShedLength`";
            PreparedStatement l_pStatement = l_cCon.prepareStatement(l_sSQL);
            ResultSet l_rsSearch = l_pStatement.executeQuery();
            while (l_rsSearch.next()) {
                values.add(l_rsSearch.getInt(1));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DataException(ex.getMessage());
        }
        return values;
    }

    /**
     * Update the database with a new customer.
     *
     * @param name name of customer 
     * @param adress adress of customer
     * @param city city of customer
     * @param phoneNumber customers phonenumber
     * @param email email of customer
     * @throws DataException if query fails
     */
    public static void createCustomer(String name, String adress, String city, String phoneNumber, String email) throws DataException {
        String l_sSQL = "INSERT INTO `Customer` (`ID`,`Name`,`Adress`,`City`,`Phonenumber`,`Email`) VALUES (NULL, ?, ?, ?, ?, ?)";
        try {
            Connection l_cCon = Connector.connection();
            PreparedStatement l_pStatement = l_cCon.prepareStatement(l_sSQL);
            l_pStatement.setString(1, name);
            l_pStatement.setString(2, adress);
            l_pStatement.setString(3, city);
            l_pStatement.setString(4, phoneNumber);
            l_pStatement.setString(5, email);
            l_pStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DataException(ex.getMessage() + " " + l_sSQL);
        }
    }

    /**
     * Update the database with a new order.
     *
     * Method for merging a customer with a carport
     *
     * @param customerID customerID related to Order being created
     * @param carportID carportID related to Order being created
     * @throws OrderException if query fails
     */
    public static void createOrder(int customerID, int carportID) throws OrderException {
        String l_sSQL = "INSERT INTO `Order` (`OrderID`,`customerID`,`idCarport`) VALUES (NULL, " + customerID + ", " + carportID + ")";
        try {
            Connection l_cCon = Connector.connection();
            PreparedStatement l_pStatement = l_cCon.prepareStatement(l_sSQL);
            l_pStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new OrderException(ex.getMessage() + " " + l_sSQL);
        }
    }

    /**
     * Returns a customers id based on a unique phonenumber.
     *
     *
     * @param phoneNumber finds a customer based on their phone number
     * @return CustomerID an int representing a customers id
     * @throws DataException if query fails
     */
    public static int getCustomerIDByPhoneNumber(String phoneNumber) throws DataException {
        String l_sSQL = "SELECT ID FROM `Customer` WHERE Phonenumber = " + phoneNumber;
        int CustomerID = 0;
        try {
            Connection l_cCon = Connector.connection();
            PreparedStatement l_pStatement = l_cCon.prepareStatement(l_sSQL);
            ResultSet l_rsSearch = l_pStatement.executeQuery();
            if (l_rsSearch.next()) {
                CustomerID = l_rsSearch.getInt(1);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DataException(ex.getMessage() + " " + l_sSQL);
        }
        return CustomerID;
    }

    /**
     * Returns a carport id based on a customers id.
     *
     *
     * @param customerID retrieves a carportID by a customerID related to it
     * @return an int representing a carports id
     * @throws DataException if query fails
     */
    public static int getCarportIDByCustomerID(int customerID) throws DataException {
        int CarportID = 0;
        String l_sSQL = "SELECT c1.idCarport FROM `Carport` c1, `Customer` c2, `Order` o1 WHERE c1.idCarport = o1.idCarport AND " + customerID + " = o1.customerID";
        try {
            Connection l_cCon = Connector.connection();
            PreparedStatement l_pStatement = l_cCon.prepareStatement(l_sSQL);
            ResultSet l_rsSearch = l_pStatement.executeQuery();
            if (l_rsSearch.next()) {
                CarportID = l_rsSearch.getInt(1);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DataException(ex.getMessage() + " " + l_sSQL);
        }
        return CarportID;
    }

    /**
     * Creates a new product in the database.
     *
     * @param name name of product
     * @param price price of product
     * @param description description of product
     * @param length length of product
     * @param unit units of product
     * @throws DataException if query fails
     */
    public static void createProduct(String name, int price, String description, int length, int unit) throws DataException {
        String l_sSQL = "INSERT INTO `Produkter` (`Id`,`Navn`,`Pris`,`Beskrivelse`,`Længde`,`Enhed`) VALUES (NULL," + name + ", " + price + ", " + description + ", " + length
                + ", " + unit + ")";
        try {
            Connection l_cCon = Connector.connection();
            PreparedStatement l_pStatement = l_cCon.prepareStatement(l_sSQL);
            l_pStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DataException(ex.getMessage() + " " + l_sSQL);
        }
    }

    /**
     * Updates a product if exist or creates a new product if not
     *
     * @param productID integer ID
     * @param name String name
     * @param price int price
     * @param description string description
     * @param length int length
     * @param unit int unit
     * @param type string type
     * @throws DataException if query fails
     */
    public static void updateProductOrAdd(int productID, String name, double price, String description, int length, String unit, String type) throws DataException {
        String l_sSQL;
        if (productID != 0) {
            l_sSQL = "INSERT INTO `Produkter` (`Id`,`Navn`,`Pris`,`Beskrivelse`,`Længde`,`Enhed`,`Type`) VALUES (" + productID + ", ?, ?, ?, ?, ?, ?)"
                    + "ON DUPLICATE KEY UPDATE `Navn`= ?,`Pris`= ?,`Beskrivelse`= ?,`Længde`= ?,`Enhed`= ?,`Type`= ?";
        } else {
            l_sSQL = "INSERT INTO `Produkter` (`Id`,`Navn`,`Pris`,`Beskrivelse`,`Længde`,`Enhed`,`Type`) VALUES (NULL, ?, ?, ?, ?, ?, ?)"
                    + "ON DUPLICATE KEY UPDATE `Navn`= ?,`Pris`= ?,`Beskrivelse`= ?,`Længde`= ?,`Enhed`= ?,`Type`= ?";
        }
        try {
            Connection l_cCon = Connector.connection();
            PreparedStatement l_pStatement = l_cCon.prepareStatement(l_sSQL);
            l_pStatement.setString(1, name);
            l_pStatement.setDouble(2, price);
            l_pStatement.setString(3, description);
            l_pStatement.setInt(4, length);
            l_pStatement.setString(5, unit);
            l_pStatement.setString(6, type);
            l_pStatement.setString(7, name);
            l_pStatement.setDouble(8, price);
            l_pStatement.setString(9, description);
            l_pStatement.setInt(10, length);
            l_pStatement.setString(11, unit);
            l_pStatement.setString(12, type);
            l_pStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DataException(ex.getMessage() + " " + l_sSQL);
        }
    }

    /**
     * Returns a list of material based on their type
     *
     * @param type string materials
     * @return A list of materials
     * @throws DataException if query fails
     */
    public static List<Material> getAllMaterialsByType(String type) throws DataException {
        List<Material> allMaterials = new ArrayList();
        Material materiale;
        String l_sSQL = "SELECT Navn, Beskrivelse, Enhed, Længde, Pris FROM `Produkter` WHERE Type = \"" + type + "\" ORDER BY Længde DESC;";
        try {
            Connection l_cCon = Connector.connection();
            Statement l_pStatement = l_cCon.prepareStatement(l_sSQL);
            ResultSet l_rsSearch = l_pStatement.executeQuery(l_sSQL);
            while (l_rsSearch.next()) {
                materiale = new Material(
                        l_rsSearch.getString(1),
                        l_rsSearch.getString(2),
                        l_rsSearch.getString(3),
                        l_rsSearch.getInt(4),
                        l_rsSearch.getInt(5));
                materiale.setType(type);
                allMaterials.add(materiale);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DataException(ex.getMessage() + " " + l_sSQL);
        }
        return allMaterials;
    }

    /**
     * Returns a list of all materials
     *
     * @return A list of materials
     * @throws DataException if query fails
     */
    public static List<Material> getAllMaterials() throws DataException {
        List<Material> allMaterials = new ArrayList();
        Material materiale;
        String l_sSQL = "SELECT Navn, Beskrivelse, Enhed, Type, Længde, Id, Pris FROM `Produkter`";
        try {
            Connection l_cCon = Connector.connection();
            Statement l_pStatement = l_cCon.prepareStatement(l_sSQL);
            ResultSet l_rsSearch = l_pStatement.executeQuery(l_sSQL);
            while (l_rsSearch.next()) {
                materiale = new Material(
                        l_rsSearch.getString(1), // navn
                        l_rsSearch.getString(2), // beskrivelse
                        l_rsSearch.getString(3), // enhed
                        l_rsSearch.getString(4), // type
                        l_rsSearch.getInt(5), // længde
                        l_rsSearch.getInt(6), // id
                        l_rsSearch.getInt(7)); // pris
                allMaterials.add(materiale);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DataException(ex.getMessage() + " " + l_sSQL);
        }
        return allMaterials;
    }

    /**
     * Creates a new carport and returns a integer representing the last carport added
     *
     * @param carport carport object to use
     * @return CarportId
     * @throws DataException if query fails
     */
    public static int addCarport(Carport carport) throws DataException {
        String l_sSQL = "INSERT INTO `Carport` (`idCarport`,`Width`,`Length`,`ShedWidth`,`ShedLength`,`Roof`,`Shed`) VALUES (NULL,?, ?, ?, ?, ?, ?)";
        int carportID = 1;
        try {
            Connection l_cCon = Connector.connection();
            PreparedStatement l_pStatement = l_cCon.prepareStatement(l_sSQL);
            l_pStatement.setInt(1, carport.getWidth());
            l_pStatement.setInt(2, carport.getLength());
            l_pStatement.setInt(3, carport.getShedWidth());
            l_pStatement.setInt(4, carport.getShedLength());
            l_pStatement.setBoolean(5, carport.isRoofChosen());
            l_pStatement.setBoolean(6, carport.isShedChosen());
            l_pStatement.executeUpdate();
            l_sSQL = "SELECT idCarport FROM `Carport` WHERE idCarport=(SELECT MAX(idCarport) FROM `Carport`);";
            l_pStatement = l_cCon.prepareStatement(l_sSQL);
            ResultSet l_rsSearch = l_pStatement.executeQuery(l_sSQL);
            if (l_rsSearch.next()) {
                carportID = l_rsSearch.getInt(1);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DataException(ex.getMessage() + " " + l_sSQL);
        }
        return carportID;
    }
}
