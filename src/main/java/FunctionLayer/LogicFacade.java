/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import FunctionLayer.Calculators.Calculator;
import FunctionLayer.Exceptions.DataException;
import DBAccess.DataMapper;
import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import FunctionLayer.Exceptions.OrderException;
import FunctionLayer.Exceptions.UserException;
import PresentationLayer.Order;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class LogicFacade {

    /**
     * DEPRECATED
     *
     * @return originally planned as returning all materials (DEPRECATED)
     * @deprecated
     */
    public static List<Carport> getMaterials() {
        List<Carport> totalMaterials = new ArrayList();

        return totalMaterials;
    }

    /**
     * DEPRECATED
     *
     * @param indexID was used to define Orders
     * @return originally planned as returning all materials based on an Index
     * (DEPRECATED)
     * @throws FunctionLayer.Exceptions.DataException
     * @deprecated
     */
    public static List<Material> calculateOrder(int indexID) throws DataException {
        List<Material> materials = DataMapper.calculateOrder(indexID);

        return materials;
    }

    /**
     * DEPRECATED
     *
     * @param length int to define length
     * @param width int to define width
     * @return would return a carport
     * @deprecated
     */
    public static Carport createCarport(int length, int width) {
        Carport createCarport = new Carport(length, width);
        return createCarport;
    }

    /**
     * returns a list of available widths for carports
     *
     * @return widths available for a carport
     * @throws FunctionLayer.Exceptions.DataException
     */
    public static List<Integer> getWidth() throws DataException {
        List<Integer> width = DataMapper.getWidth();
        return width;
    }

    /**
     * returns a list of available lengths for carports
     *
     * @return lengths available for a carport
     * @throws FunctionLayer.Exceptions.DataException
     */
    public static List<Integer> getLength() throws DataException {
        List<Integer> length = DataMapper.getLength();
        return length;
    }

    /**
     * returns a list of available shedwidth for carports
     *
     * @return shedwidths available for a carport
     * @throws FunctionLayer.Exceptions.DataException
     */
    public static List<Integer> getShedWidth() throws DataException {
        List<Integer> width = DataMapper.getShedWidth();
        return width;
    }

    /**
     * returns a list of available shedLength for carports
     *
     * @return shedLength available for a carport
     * @throws FunctionLayer.Exceptions.DataException
     */
    public static List<Integer> getShedLength() throws DataException {
        List<Integer> length = DataMapper.getShedLength();
        return length;
    }

    /**
     * returns a calculated carport
     *
     * @param carport to be calculated
     * @return a method from the calculator class to evaluate the carport
     * @throws FunctionLayer.Exceptions.DataException
     */
    public static Carport calculateCarportList(Carport carport) throws DataException {
        Calculator calculator = new Calculator(carport, getAllMaterials());
        return calculator.getCalculatedCarport();
    }

    /**
     * returns a list of all materials collected from the DB
     *
     * @return list of all available materials
     * @throws FunctionLayer.Exceptions.DataException
     */
    public static List<Material> getAllMaterials() throws DataException {
        List<Material> getAllMaterials = DataMapper.getAllMaterials();
        return getAllMaterials;
    }

    /**
     * returns a list of all materials based on type name
     *
     * @param string a type of material by name
     * @return list of all materials based on their type
     * @throws FunctionLayer.Exceptions.DataException
     */
    public static List<Material> listOfMaterialsByType(String string) throws DataException {
        return DataMapper.getAllMaterialsByType(string);
    }

    /**
     * repetition of getAllMaterials method
     *
     * @return list of all materials
     * @throws FunctionLayer.Exceptions.DataException
     */
    public static List<Material> listOfAllMaterials() throws DataException {

        return DataMapper.getAllMaterials();
    }

    /**
     * Updates a product in the DB or Adds a new one
     *
     * @param ID Product ID
     * @param name name of product
     * @param price of product
     * @param description of product
     * @param length of product
     * @param unit of product
     * @param type of product
     * @throws FunctionLayer.Exceptions.DataException
     */
    public static void updateProductOrAdd(int ID, String name, Double price, String description, Integer length, String unit, String type) throws DataException {
        DataMapper.updateProductOrAdd(ID, name, price, description, length, unit, type);
    }

    /**
     * creates a customer
     *
     * @param name name of product
     * @param address of customer
     * @param city of customer
     * @param number phonenumber of customer
     * @param email of customer
     * @throws FunctionLayer.Exceptions.DataException
     */
    public static void createCustomer(String name, String address, String city, String number, String email) throws DataException {
        DataMapper.createCustomer(name, address, city, number, email);
    }

    /**
     * creates a user in the UserMapper
     * 
     * @param user to be created in the DataBase
     * @throws FunctionLayer.Exceptions.UserException
     */
    public static void createUser(User user) throws UserException {
        UserMapper.createUser(user);
    }

    /**
     * Inserts a pdf into the Database
     *
     * @param OrderId Int of the Order
     * @param pdf a Byte Array which is the PDF to be inserted through the OrderMapper
     * @throws FunctionLayer.Exceptions.OrderException
     */
    public static void inserPdf(int OrderId, byte[] pdf) throws OrderException {
        OrderMapper.insertPdf(OrderId, pdf);
    }

    /**
     * checks based on an email and password is a user is an admin in the Database
     *
     * @param Email email to check
     * @param Pw password to check
     * @return false or true based on if the role is Admin
     * @throws FunctionLayer.Exceptions.UserException
     */
    public static boolean isAdmin(String Email, String Pw) throws UserException {
        String Role = UserMapper.getLoginRole(Email, Pw);
        return Role.equals("admin");
    }

    /**
     * Gets all Order lists from the Database
     *
     * @return a list of all Orders available in the Database
     * @throws FunctionLayer.Exceptions.OrderException
     */
    public static List<Order> getOrderlist() throws OrderException {
        List<Order> orderlist = OrderMapper.getOrderList();
        return orderlist;
    }

    /**
     * Deletes an order from the Database
     *
     * @param OrderID int to specify which Order to delete
     * @throws FunctionLayer.Exceptions.OrderException
     */
    public static void deleteOrder(int OrderID) throws OrderException {
        OrderMapper.deleteOrder(OrderID);
    }

     /**
     * Edits an Order from the Database through the OrderMapper
     *
     * @param OrderID int to specify which Order to delete
     * @param customerID int to specify which customer is specified
     * @param carportID int to specify which carport is specified
     * @param name name of customer
     * @param adress address of customer
     * @param city city of customer
     * @param phone phonenumber of customer
     * @param email email of customer
     * @param role permission role (customer, admin)
     * @param width width of carport
     * @param length length of carport
     * @param shedwidth width of shed
     * @param shedlength length of shed
     * @param roof checks what roof type is specified
     * @param shed checks if a shed is included
     * @throws FunctionLayer.Exceptions.OrderException
     */
    public static void editOrder(int OrderID, int customerID, int carportID, String name, String adress, String city, String phone, String email, String role, int width, int length, int shedwidth, int shedlength, boolean roof, boolean shed) throws OrderException {
        OrderMapper.editOrder(OrderID, customerID, carportID, name, adress, city, phone, email, role, width, length, shedwidth, shedlength, roof, shed);
    }

    /**
     * Tries to log in with an email and password, makes an user based on that
     *
     * @param Email of the user
     * @param Pw of the user
     * @return either a user based on email/pw or a null refference handled later
     * @throws FunctionLayer.Exceptions.UserException
     */
    public static User isUser(String Email, String Pw) throws UserException {
        User user = UserMapper.login(Email, Pw);
        return user;
    }

    /**
     * adds the newest Order to the Database based on the most recent carport ID created
     * @param user user to access OrderMapper
     * @param carport carport to receive the int ID required
     * @throws FunctionLayer.Exceptions.DataException
     * @throws FunctionLayer.Exceptions.OrderException
     */
    public static void addOrderCompletely(User user, Carport carport) throws DataException, OrderException {
        int carportID = DataMapper.addCarport(carport);
        OrderMapper.addOrder(user, carportID);
    }

    /**
     * 
     * @param orderId int to tell what order is specified
     * @return returns an whole Order based on DataBase
     * @throws OrderException 
     */
    public static Order getOrderById(int orderId) throws OrderException {

        return OrderMapper.getOrderById(orderId);
    }
}
