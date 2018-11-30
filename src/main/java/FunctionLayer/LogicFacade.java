/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.DataMapper;
import DBAccess.OrderMapper;
import DBAccess.UserMapper;
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

    public static List<Materiale> calculateOrder(Carport dimension, int indexID) throws LoginSampleException {
        List<Materiale> materials = DataMapper.calculateOrder(dimension, indexID);

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
        Calculator calculator = new Calculator(carport);
        return calculator.getCalculatedCarport();
    }

    public static List<Materiale> listOfMaterialsByType(String string) throws LoginSampleException {
        return DataMapper.getAllMaterialsByType(string);
    }

    public static List<Materiale> listOfAllMaterials() throws LoginSampleException {

        return DataMapper.getAllMaterials();
    }

    public static void updateProductOrAdd(int ID, String name, Double price, String description, Integer length, String unit, String type) throws LoginSampleException {
        //throw new LoginSampleException("ID: " + ID + " name: " + name);
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
    
}
