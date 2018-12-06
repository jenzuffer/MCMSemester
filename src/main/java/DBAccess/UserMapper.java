package DBAccess;

import FunctionLayer.Exceptions.DataException;
import FunctionLayer.Exceptions.UserException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Mark
 */
public class UserMapper {

    public static void createUser(User user) throws UserException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Customer (Name, Adress, City, Phonenumber, Email, Password, Role) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setString(2, user.getAddress());
            ps.setString(3, user.getCity());
            ps.setString(4, user.getPhonenumber());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPassword());
            ps.setString(7, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new UserException("Email already in use or failure to create user " + ex.getMessage());
        }

    }

    public static User login(String email, String password) throws UserException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM Customer "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("id");
                User user = new User(email, password);
                user.setRole(role);
                user.setId(id);
                return user;
            } else {
                return null;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }

    public static String getLoginRole(String Email, String Pw) throws UserException {
        String role = "";
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT role FROM Customer "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, Email);
            ps.setString(2, Pw);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                role = rs.getString("role");
            } else {
                throw new UserException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new UserException(ex.getMessage());
        }
        return role;
    }

}
