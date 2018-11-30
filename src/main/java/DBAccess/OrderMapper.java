/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
