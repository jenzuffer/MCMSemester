/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.CarportDimensioner;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Materiale;
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

    public static CarportDimensioner changeOrder(CarportDimensioner dimension, int OrderID) throws LoginSampleException {
        try {
            Connection l_cCon = Connector.connection();
            String l_sSQL = "SELECT * FROM `width`";
            PreparedStatement l_pStatement = l_cCon.prepareStatement(l_sSQL);
            ResultSet l_rsSearch = l_pStatement.executeQuery();
            while (l_rsSearch.next()) {

            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return dimension;
    }

    public static List<Materiale> calculateOrder(CarportDimensioner dimension, int indexID) throws LoginSampleException {
        List<Materiale> materials = new ArrayList();
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

    public static void createCustomer(String name, String Adress, String City, String PhoneNumber, String Email) throws LoginSampleException {
        String l_sSQL = "INSERT INTO `Customer` (`ID`,`Name`,`Adress`,`City`,`Phonenumber`,`Email`) VALUES (NULL, " + name + ", " + Adress + ", " + City + ", "
                + PhoneNumber + ", " + Email + ")";
        try {
            Connection l_cCon = Connector.connection();
            PreparedStatement l_pStatement = l_cCon.prepareStatement(l_sSQL);
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

    public static void updateProductPrice(int ProductID, int NewPrice) throws LoginSampleException {
        String l_sSQL = "UPDATE `Produkter` SET `Pris`= NewPrice WHERE `Id`= " + ProductID;
        try {
            Connection l_cCon = Connector.connection();
            PreparedStatement l_pStatement = l_cCon.prepareStatement(l_sSQL);
            l_pStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage() + " " + l_sSQL);
        }
    }

    public static List<Materiale> getAllMaterialsByType(String type) throws LoginSampleException {
        List<Materiale> allMaterials = new ArrayList();
        Materiale materiale;
        String l_sSQL = "SELECT Navn, Beskrivelse, Enhed, Længde FROM `Produkter` WHERE Type = " + type + " ORDER BY Længde DESC;";
        try {
            Connection l_cCon = Connector.connection();
            Statement l_pStatement = l_cCon.prepareStatement(l_sSQL);
            ResultSet l_rsSearch = l_pStatement.executeQuery(l_sSQL);
            while (l_rsSearch.next()) {
                materiale = new Materiale(l_rsSearch.getString(1), l_rsSearch.getString(2), l_rsSearch.getString(3), l_rsSearch.getInt(4));
                allMaterials.add(materiale);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage() + " " + l_sSQL);
        }
        return allMaterials;
    }
}
