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

    public static void insertPdf(int orderId, InputStream pdf) throws LoginSampleException {
        Blob blob = null;
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `fog`.`Order` (`pdf`) VALUES ('?') WHERE `OrderID` = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderId);
            ps.setBlob(2, pdf);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException("Could not insert pdf" + ex.getMessage());
        }

    }
}
