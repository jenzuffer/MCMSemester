/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.List;

/**
 *
 * @author mwn
 */
public class CalculateShed {
    
    public static void calculatePoles(int length, int width, int carportWidth, List<Materiale> list) throws LoginSampleException {
        int numberOfPoles = 0;
        
        if(width == carportWidth && carportWidth <= 300 || width <= 300) {
            numberOfPoles = 2;
        } else if(width == carportWidth || width > 300) {
            numberOfPoles = 4;
        }

        if(length >= 300) numberOfPoles += 2;

        for (Materiale materiale : list) {
            if(materiale.getType().equalsIgnoreCase("stolpe")) materiale.addToAmount(numberOfPoles);
        }
    }
    
    public static void calculateCladding(int length, int width, List<Materiale> list) throws LoginSampleException {
        int circumference = length * 2 + width * 2;
        List<Materiale> listOfMaterials = LogicFacade.listOfMaterialsByType("beklædning");
        int amount = 0;
        while(circumference > 0) {
            amount += 2;
            circumference -= 18;
        }

        Materiale material = listOfMaterials.get(listOfMaterials.size() - 1);
        material.addToAmount(amount);
        list.add(material);
    }
}
