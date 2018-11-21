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

    public static void calculatePoles(int length, int width, int carportWidth, List<Materiale> list) throws LoginSampleException {
        int numberOfPoles = 0;

        int newCarportWidth = carportWidth - 30;

        if (width == newCarportWidth && carportWidth <= 300 || width <= 300) {
            numberOfPoles = 2;
        } else {
            numberOfPoles = 4;
        }

        if (length >= 600) {
            numberOfPoles += 2;
        }

        for (Materiale materiale : list) {
            if (materiale.getType().equalsIgnoreCase("stolpe")) {
                materiale.addToAmount(numberOfPoles);
            }
        }

        numOfPoles = numberOfPoles;
    }

    public static void calculateCladding(int length, int width, List<Materiale> list) throws LoginSampleException {
        List<Materiale> listOfMaterials = LogicFacade.listOfMaterialsByType("beklædning");
        int circumference = length * 2 + width * 2;
        int amount = 0;
        while (circumference > 0) {
            amount += 2;
            circumference -= 16;
        }

        Materiale material = listOfMaterials.get(listOfMaterials.size() - 1);
        material.addToAmount(amount);
        list.add(material);
    }

    public static void calculateWoodForCladding(int length, int width, List<Materiale> list) throws LoginSampleException {
        List<Materiale> listOfMaterials = LogicFacade.listOfMaterialsByType("løsholter");
        int numberWidth = 4;
        int numberLength = 4;
        int poles = 2;

        if (length >= 600) {
            numberLength = 8;
        }

        while (poles <= numOfPoles) {
            numberWidth += 4;
            poles += 2;
        }

        Materiale material = listOfMaterials.get(listOfMaterials.size() - 1);
        material.setDescription("Løsholter i skur gavle og sider");
        material.addToAmount(numberWidth + numberLength);
        list.add(material);
    }
}
