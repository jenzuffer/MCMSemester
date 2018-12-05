/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.DataMapper;
import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import PresentationLayer.Order;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class LogicFacade {

    public static List<Carport> getMaterials() {
        List<Carport> TotalMaterials = new ArrayList();

        return TotalMaterials;
    }

    public static List<Material> calculateOrder(Carport dimension, int indexID) throws LoginSampleException {
        List<Material> materials = DataMapper.calculateOrder(dimension, indexID);

        return materials;
    }

    public static Carport createCarport(int length, int width) {
        Carport createCarport = new Carport(length, width);
        return createCarport;
    }

    public static List<Integer> getWidth() throws LoginSampleException {
        List<Integer> width = DataMapper.getWidth();
        return width;
    }

    public static List<Integer> getLength() throws LoginSampleException {
        List<Integer> length = DataMapper.getLength();
        return length;
    }

    public static List<Integer> getShedWidth() throws LoginSampleException {
        List<Integer> width = DataMapper.getShedWidth();
        return width;
    }

    public static List<Integer> getShedLength() throws LoginSampleException {
        List<Integer> length = DataMapper.getShedLength();
        return length;
    }

    public static Carport calculateCarportList(Carport carport) throws LoginSampleException {
        Calculator calculator = new Calculator(carport, getAllMaterials());
        return calculator.getCalculatedCarport();
    }

    public static List<Material> getAllMaterials() throws LoginSampleException {
        List<Material> getAllMaterials = DataMapper.getAllMaterials();
        return getAllMaterials;
    }

    public static List<Material> listOfMaterialsByType(String string) throws LoginSampleException {
        return DataMapper.getAllMaterialsByType(string);
    }

    public static List<Material> listOfAllMaterials() throws LoginSampleException {

        return DataMapper.getAllMaterials();
    }

    public static void updateProductOrAdd(int ID, String name, Double price, String description, Integer length, String unit, String type) throws LoginSampleException {
        DataMapper.UpdateProductOrAdd(ID, name, price, description, length, unit, type);
    }

    public static void createCustomer(String name, String address, String city, String number, String email) throws LoginSampleException {
        DataMapper.createCustomer(name, address, city, number, email);
    }

    public static void createUser(User user) throws LoginSampleException {
        UserMapper.createUser(user);
    }

    public static void inserPdf(int OrderId, byte[] pdf) throws LoginSampleException {
        OrderMapper.insertPdf(OrderId, pdf);
    }

    public static boolean isAdmin(String Email, String Pw) throws LoginSampleException {
        String Role = UserMapper.getLoginRole(Email, Pw);
        if (Role.equals("admin")) {
            return true;
        }
        return false;
    }

    public static List<Order> getOrderlist() throws LoginSampleException, ClassNotFoundException {
        List<Order> orderlist = OrderMapper.getOrderList();
        return orderlist;
    }

    public static void deleteOrder(int OrderID) throws LoginSampleException {
        OrderMapper.deleteOrder(OrderID);
    }

    public static void editOrder(int OrderID, int customerID, int carportID, String name, String adress, String city, String phone, String email, String role, int width, int length, int shedwidth, int shedlength, boolean roof, boolean shed) throws LoginSampleException {
        OrderMapper.editOrder(OrderID, customerID, carportID, name, adress, city, phone, email, role, width, length, shedwidth, shedlength, roof, shed);
    }

    public static User isUser(String Email, String Pw) throws LoginSampleException {
        User user = UserMapper.login(Email, Pw);
        return user;
    }
}
