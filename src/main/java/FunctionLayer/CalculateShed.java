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

    
    
    public List<Materiale> calculatePoles(int shedLength, int shedWidth, int width) throws LoginSampleException {
        List<Materiale> listOfMaterials = LogicFacade.listOfMaterialsByType("stolpe");
        List<Materiale> returnList = new ArrayList();
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

        
        Materiale lastPole = listOfMaterials.get(listOfMaterials.size() - 1);
        lastPole.addToAmount(numberOfPoles);
        numOfPoles = numberOfPoles;
        returnList.add(lastPole);
        return returnList;
    }

    public List<Materiale> calculateCladding(int shedLength, int shedWidth) throws LoginSampleException {
        List<Materiale> listOfMaterials = LogicFacade.listOfMaterialsByType("beklædning");
        List<Materiale> returnList = new ArrayList();
        
        int circumference = shedLength * 2 + shedWidth * 2;
        int amount = 0;
        while (circumference > 0) {
            amount += 2;
            circumference -= 16;
        }
        //System.out.println("Cladding: " + amount);
        Materiale material = listOfMaterials.get(listOfMaterials.size() - 1);
        material.addToAmount(amount);
        returnList.add(material);
        return returnList;
    }

    public List<Materiale> calculateWoodForCladding(int shedLength, int shedWidth) throws LoginSampleException {
        List<Materiale> listOfMaterials = LogicFacade.listOfMaterialsByType("løsholter");
        List<Materiale> returnList = new ArrayList();
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
        
        Materiale material = listOfMaterials.get(listOfMaterials.size() - 1);
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
