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

    public static List<Carport> getMaterials() {
        List<Carport> totalMaterials = new ArrayList();

        return totalMaterials;
    }

    public static List<Material> calculateOrder(int indexID) throws DataException {
        List<Material> materials = DataMapper.calculateOrder(indexID);

        return materials;
    }

    public static Carport createCarport(int length, int width) {
        Carport createCarport = new Carport(length, width);
        return createCarport;
    }

    public static List<Integer> getWidth() throws DataException {
        List<Integer> width = DataMapper.getWidth();
        return width;
    }

    public static List<Integer> getLength() throws DataException {
        List<Integer> length = DataMapper.getLength();
        return length;
    }

    public static List<Integer> getShedWidth() throws DataException {
        List<Integer> width = DataMapper.getShedWidth();
        return width;
    }

    public static List<Integer> getShedLength() throws DataException {
        List<Integer> length = DataMapper.getShedLength();
        return length;
    }

    public static Carport calculateCarportList(Carport carport) throws DataException {
        Calculator calculator = new Calculator(carport, getAllMaterials());
        return calculator.getCalculatedCarport();
    }

    public static List<Material> getAllMaterials() throws DataException {
        List<Material> getAllMaterials = DataMapper.getAllMaterials();
        return getAllMaterials;
    }

    public static List<Material> listOfMaterialsByType(String string) throws DataException {
        return DataMapper.getAllMaterialsByType(string);
    }

    public static List<Material> listOfAllMaterials() throws DataException {

        return DataMapper.getAllMaterials();
    }

    public static void updateProductOrAdd(int ID, String name, Double price, String description, Integer length, String unit, String type) throws DataException {
        DataMapper.updateProductOrAdd(ID, name, price, description, length, unit, type);
    }

    public static void createCustomer(String name, String address, String city, String number, String email) throws DataException {
        DataMapper.createCustomer(name, address, city, number, email);
    }

    public static void createUser(User user) throws UserException {
        UserMapper.createUser(user);
    }

    public static void inserPdf(int OrderId, byte[] pdf) throws OrderException {
        OrderMapper.insertPdf(OrderId, pdf);
    }

    public static boolean isAdmin(String Email, String Pw) throws UserException {
        String Role = UserMapper.getLoginRole(Email, Pw);
        return Role.equals("admin");
    }

    public static List<Order> getOrderlist() throws OrderException {
        List<Order> orderlist = OrderMapper.getOrderList();
        return orderlist;
    }

    public static void deleteOrder(int OrderID) throws OrderException {
        OrderMapper.deleteOrder(OrderID);
    }

    public static void editOrder(int OrderID, int customerID, int carportID, String name, String adress, String city, String phone, String email, String role, int width, int length, int shedwidth, int shedlength, boolean roof, boolean shed) throws OrderException {
        OrderMapper.editOrder(OrderID, customerID, carportID, name, adress, city, phone, email, role, width, length, shedwidth, shedlength, roof, shed);
    }

    public static User isUser(String Email, String Pw) throws UserException {
        User user = UserMapper.login(Email, Pw);
        return user;
    }

    public static void addOrderCompletely(User user, Carport carport) throws DataException, OrderException {
        int carportID = DataMapper.addCarport(carport);
        OrderMapper.addOrder(user, carportID);
    }
}
