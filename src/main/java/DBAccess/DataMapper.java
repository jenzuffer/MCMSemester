/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Carport;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Material;
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
 * @author Christian
 */
public class DataMapper {

    public static List<Material> calculateOrder(Carport dimension, int indexID) throws LoginSampleException {
        List<Material> materials = new ArrayList();
        try {
            Connection l_cCon = Connector.connection();
            String l_sSQL = "SELECT * FROM `Materiale` WHERE id = " + indexID;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return materials;
    }

    public static List<Integer> getWidth() throws LoginSampleException {
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
            throw new LoginSampleException(ex.getMessage());
        }
        return values;
    }

    public static List<Integer> getLength() throws LoginSampleException {
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
            throw new LoginSampleException(ex.getMessage());
        }
        return values;
    }

    public static List<Integer> getShedWidth() throws LoginSampleException {
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
            throw new LoginSampleException(ex.getMessage());
        }
        return values;
    }

    public static List<Integer> getShedLength() throws LoginSampleException {
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
            throw new LoginSampleException(ex.getMessage());
        }
        return values;
    }

    public static void createCustomer(String name, String Adress, String City, String PhoneNumber, String Email) throws LoginSampleException {
        String l_sSQL = "INSERT INTO `Customer` (`ID`,`Name`,`Adress`,`City`,`Phonenumber`,`Email`) VALUES (NULL, ?, ?, ?, ?, ?)";
        try {
            Connection l_cCon = Connector.connection();
            PreparedStatement l_pStatement = l_cCon.prepareStatement(l_sSQL);
            l_pStatement.setString(1, name);
            l_pStatement.setString(2, Adress);
            l_pStatement.setString(3, City);
            l_pStatement.setString(4, PhoneNumber);
            l_pStatement.setString(5, Email);
            l_pStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage() + " " + l_sSQL);
        }
    }

    public static void createCarport(int Heigth, int Width, int Length) throws LoginSampleException {
        String l_sSQL = "INSERT INTO `Carport` (`idCarport`,`Height`,`Width`,`Length`) VALUES (NULL, " + Heigth + ", " + Width + ", " + Length + ")";
        try {
            Connection l_cCon = Connector.connection();
            PreparedStatement l_pStatement = l_cCon.prepareStatement(l_sSQL);
            l_pStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage() + " " + l_sSQL);
        }
    }

    public static void createOrder(int CustomerID, int CarportID) throws LoginSampleException {
        String l_sSQL = "INSERT INTO `Order` (`OrderID`,`customerID`,`idCarport`) VALUES (NULL, " + CustomerID + ", " + CarportID + ")";
        try {
            Connection l_cCon = Connector.connection();
            PreparedStatement l_pStatement = l_cCon.prepareStatement(l_sSQL);
            l_pStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage() + " " + l_sSQL);
        }
    }

    public static int getCustomerIDByPhoneNumber(String PhoneNumber) throws LoginSampleException {
        String l_sSQL = "SELECT ID FROM `Customer` WHERE Phonenumber = " + PhoneNumber;
        int CustomerID = 0;
        try {
            Connection l_cCon = Connector.connection();
            PreparedStatement l_pStatement = l_cCon.prepareStatement(l_sSQL);
            ResultSet l_rsSearch = l_pStatement.executeQuery();
            if (l_rsSearch.next()) {
                CustomerID = l_rsSearch.getInt(1);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage() + " " + l_sSQL);
        }
        return CustomerID;
    }

    public static int getCarportIDByCustomerID(int CustomerID) throws LoginSampleException {
        int CarportID = 0;
        String l_sSQL = "SELECT c1.idCarport FROM `Carport` c1, `Customer` c2, `Order` o1 WHERE c1.idCarport = o1.idCarport AND " + CustomerID + " = o1.customerID";
        try {
            Connection l_cCon = Connector.connection();
            PreparedStatement l_pStatement = l_cCon.prepareStatement(l_sSQL);
            ResultSet l_rsSearch = l_pStatement.executeQuery();
            if (l_rsSearch.next()) {
                CarportID = l_rsSearch.getInt(1);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage() + " " + l_sSQL);
        }
        return CarportID;
    }

    public static void createProduct(String Name, int Price, String Description, int Length, int Unit) throws LoginSampleException {
        String l_sSQL = "INSERT INTO `Produkter` (`Id`,`Navn`,`Pris`,`Beskrivelse`,`Længde`,`Enhed`) VALUES (NULL," + Name + ", " + Price + ", " + Description + ", " + Length
                + ", " + Unit + ")";
        try {
            Connection l_cCon = Connector.connection();
            PreparedStatement l_pStatement = l_cCon.prepareStatement(l_sSQL);
            l_pStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage() + " " + l_sSQL);
        }
    }

    public static void createMaterial(String MaterialName) throws LoginSampleException {
        String l_sSQL = "INSERT INTO `Materials` (`ID`,`MaterialeNavn`) VALUES (NULL, " + MaterialName + ")";
        try {
            Connection l_cCon = Connector.connection();
            PreparedStatement l_pStatement = l_cCon.prepareStatement(l_sSQL);
            l_pStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage() + " " + l_sSQL);
        }
    }

    public static void UpdateProductOrAdd(int ProductID, String Name, double Price, String Description, int length, String Unit, String Type) throws LoginSampleException {
        String l_sSQL = "";
        if (ProductID != 0) {
            l_sSQL = "INSERT INTO `Produkter` (`Id`,`Navn`,`Pris`,`Beskrivelse`,`Længde`,`Enhed`,`Type`) VALUES (" + ProductID + ", ?, ?, ?, ?, ?, ?)"
                    + "ON DUPLICATE KEY UPDATE `Navn`= ?,`Pris`= ?,`Beskrivelse`= ?,`Længde`= ?,`Enhed`= ?,`Type`= ?";
        } else {
            l_sSQL = "INSERT INTO `Produkter` (`Id`,`Navn`,`Pris`,`Beskrivelse`,`Længde`,`Enhed`,`Type`) VALUES (NULL, ?, ?, ?, ?, ?, ?)"
                    + "ON DUPLICATE KEY UPDATE `Navn`= ?,`Pris`= ?,`Beskrivelse`= ?,`Længde`= ?,`Enhed`= ?,`Type`= ?";
        }
        try {
            Connection l_cCon = Connector.connection();
            PreparedStatement l_pStatement = l_cCon.prepareStatement(l_sSQL);
            l_pStatement.setString(1, Name);
            l_pStatement.setDouble(2, Price);
            l_pStatement.setString(3, Description);
            l_pStatement.setInt(4, length);
            l_pStatement.setString(5, Unit);
            l_pStatement.setString(6, Type);
            l_pStatement.setString(7, Name);
            l_pStatement.setDouble(8, Price);
            l_pStatement.setString(9, Description);
            l_pStatement.setInt(10, length);
            l_pStatement.setString(11, Unit);
            l_pStatement.setString(12, Type);
            l_pStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage() + " " + l_sSQL);
        }
    }

    public static List<Material> getAllMaterialsByType(String type) throws LoginSampleException {
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
            throw new LoginSampleException(ex.getMessage() + " " + l_sSQL);
        }
        return allMaterials;
    }

    public static List<Material> getAllMaterials() throws LoginSampleException {
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
            throw new LoginSampleException(ex.getMessage() + " " + l_sSQL);
        }
        return allMaterials;
    }
}
