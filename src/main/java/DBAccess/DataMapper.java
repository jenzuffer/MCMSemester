/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.CarportDimensioner;
import FunctionLayer.LoginSampleException;
import PresentationLayer.Materials;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Christian
 */
public class DataMapper {

    public static CarportDimensioner ChangeOrder(CarportDimensioner dimension, int OrderID) throws LoginSampleException {
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

    public static List<Materials> CalculateOrder(CarportDimensioner dimension, int indexID) throws LoginSampleException {
        List<Materials> materials = new ArrayList();
        try {
            Connection l_cCon = Connector.connection();
            String l_sSQL = "SELECT * FROM `Materiale` WHERE id = " + indexID;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return materials;
    }

    public static Map<Integer, Integer> GetWidthAndLength() throws LoginSampleException {
        Map<Integer, Integer> HM = new HashMap();
         try {
            Connection l_cCon = Connector.connection();
            //query bliver lidt mere tricky hvis de skal havde forskellige værdier
            String l_sSQL = "SELECT * FROM `width` m1, `length` t1 WHERE m1.width = t1.length";
            PreparedStatement l_pStatement = l_cCon.prepareStatement(l_sSQL);
            ResultSet l_rsSearch = l_pStatement.executeQuery();
            while (l_rsSearch.next()) {
                 HM.put(l_rsSearch.getInt(1), l_rsSearch.getInt(2));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return HM;
    }
}
