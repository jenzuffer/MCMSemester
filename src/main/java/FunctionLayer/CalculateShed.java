/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mwn
 */
public class CalculateShed {

    private static int numOfPoles;

    
    
    public List<Material> calculatePoles(List<Material> materials ,int shedLength, int shedWidth, int width) throws LoginSampleException {
        List<Material> returnList = new ArrayList();
        List<Material> listOfMaterials = LogicFacade.listOfMaterialsByType("stolpe");
        /*
        for (Materiale material : materials) {
            if ("stolpe".equals(material.getType())) {
                listOfMaterials.add(material);
            }
        }
        */
        
        
        int numberOfPoles = 0;

        int newCarportWidth = width - 30;

        if (shedWidth == newCarportWidth && width <= 300 || shedWidth <= 300) {
            numberOfPoles = 2;
        } else {
            numberOfPoles = 4;
        }

        if (shedLength >= 600) {
            numberOfPoles += 2;
        }

        
        Material lastPole = listOfMaterials.get(listOfMaterials.size() - 1);
        lastPole.addToAmount(numberOfPoles);
        numOfPoles = numberOfPoles;
        returnList.add(lastPole);
        return returnList;
    }

    public List<Material> calculateCladding(List<Material> materials, int shedLength, int shedWidth) throws LoginSampleException {
        List<Material> returnList = new ArrayList();
        List<Material> listOfMaterials = LogicFacade.listOfMaterialsByType("beklædning");
        /*
        for (Materiale material : materials) {
            if ("beklædning".equals(material.getType())) {
                listOfMaterials.add(material);
            }
        }
        */
        int circumference = shedLength * 2 + shedWidth * 2;
        int amount = 0;
        while (circumference > 0) {
            amount += 2;
            circumference -= 16;
        }
        //System.out.println("Cladding: " + amount);
        Material material = listOfMaterials.get(listOfMaterials.size() - 1);
        material.addToAmount(amount);
        returnList.add(material);
        return returnList;
    }

    public List<Material> calculateWoodForCladding(List<Material> materials, int shedLength, int shedWidth) throws LoginSampleException {
        List<Material> listOfMaterials = LogicFacade.listOfMaterialsByType("løsholter");;
        List<Material> returnList = new ArrayList();
        /*
        for (Materiale material : materials) {
            if ("løsholter".equals(material.getType())) {
                listOfMaterials.add(material);
            }
        }
        */
        int numberWidth = 4;
        int numberLength = 4;
        int poles = 2;

        if (shedLength >= 600) {
            numberLength = 8;
        }

        while (poles <= numOfPoles) {
            numberWidth += 4;
            poles += 2;
        }
        
        Material material = listOfMaterials.get(listOfMaterials.size() - 1);
        material.setDescription("Løsholter i skur gavle og sider");
        material.addToAmount(numberWidth + numberLength);
        returnList.add(material);
        return returnList;
    }
    
    
//    public static void main(String[] args) throws LoginSampleException {
//        List<List<Materiale>> list = new ArrayList();
//        CalculateShed s= new CalculateShed();
//        list.add(s.calculatePoles(210, 530, 600));
//        list.add(s.calculateCladding(210, 530));
//        list.add(s.calculateWoodForCladding(210, 530));
//        
//        for (List<Materiale> list1 : list) {
//            for (Materiale m : list1) {
//                System.out.println(m.getName() + " " + m.getAmount());
//            }
//        }
//    }
}
