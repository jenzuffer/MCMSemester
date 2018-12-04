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
 * @author Christian
 */
public class CalculateRoof {

        
    public List<Material> CalculateRoofPlates(List<Material> materials, int length, int width, boolean tag) throws LoginSampleException {
        List<Material> returnlist = new ArrayList();
        List<Material> listofRoofPlates = LogicFacade.listOfMaterialsByType("tagplader");
        /*
        for (Materiale material : materials) {
            if ("tagplader".equals(material.getType())) {
                listofRoofPlates.add(material);
            }
        }
        */
        int RaftersAmount = calculateRaftersAmount(materials, length, width);
        if (tag) {
            RaftersAmount *= 1.5;
        }
        int saveLength = length; //eksempel 450
        int IndexX = 0;
        int iLength = 55;
        while (saveLength > iLength && IndexX < listofRoofPlates.size()) {
            while (saveLength >= listofRoofPlates.get(IndexX).getLength()) {
                saveLength -= listofRoofPlates.get(IndexX).getLength();
                listofRoofPlates.get(IndexX).addToAmount(1);
            }
            listofRoofPlates.get(IndexX).setDescription("tagplader der monteres på spær");
            listofRoofPlates.get(IndexX).addToAmount(((RaftersAmount / 6) * 2) - 1);
            returnlist.add(listofRoofPlates.get(IndexX));
            IndexX++;
        }
        //throw new LoginSampleException("saveLength: " + saveLength + " amount: " + listofRoofPlates.get(IndexX - 1).getAmount() +  " raftersamount: " + RaftersAmount);
        if (saveLength > 0 && saveLength < iLength) {
            returnlist.get(returnlist.size() - 1).addToAmount(- 1);
        } else if (saveLength > 0 && IndexX == listofRoofPlates.size()) {
            while (saveLength > 0) {
                saveLength -= listofRoofPlates.get(listofRoofPlates.size() - 1).getLength();
                returnlist.get(returnlist.size() - 1).addToAmount(1);
            }
            //skulle måske ændres igen
            if (listofRoofPlates.get(listofRoofPlates.size() - 1).getAmount() % 2 != 0) {
                returnlist.get(returnlist.size() - 1).addToAmount(1);
            }
        }
        return returnlist;
    }

    public int calculateRaftersAmount(List<Material> materials ,int length, int width) throws LoginSampleException {
        int countReturn = 0;
        int iWidth = width;
        double coverPiece = length / 55;
        int amountOfPieces = 0;
        if (coverPiece != (double) length / 55) {
            amountOfPieces = length / 55 + 1;
        } else {
            amountOfPieces = length / 55;
        }
        List<Material> listOfMaterials = LogicFacade.listOfMaterialsByType("spærtræ");;
        /*
        for (Materiale material : materials) {
            if ("spærtræ".equals(material.getType())) {
                listOfMaterials.add(material);
            }
        }
        */
        for (Material materiale : listOfMaterials) {
            if (iWidth >= materiale.getLength()) {
                materiale.addToAmount(amountOfPieces);
                iWidth = iWidth - materiale.getLength();
            }
            int count = 0;
            if (materiale.getAmount() > 0) {
                for (; count < iWidth * amountOfPieces / materiale.getLength(); count++) {
                    materiale.addToAmount(1);
                }
            }
            if (iWidth == width && listOfMaterials.get(listOfMaterials.size() - 1) == materiale) {
                materiale.addToAmount(amountOfPieces);
            }
            if (materiale.getAmount() > 0) {
                countReturn += materiale.getAmount();
            }
            if (iWidth <= 0) {
                break;
            }
            if (iWidth * amountOfPieces < listOfMaterials.get(listOfMaterials.size() - 1).getLength()) {
                Material lastMateriale = listOfMaterials.get(listOfMaterials.size() - 1);
                lastMateriale.addToAmount(1);
                if (materiale != listOfMaterials.get(listOfMaterials.size() - 1)) {
                    countReturn += lastMateriale.getAmount();
                }
                break;
            }
        }
        return countReturn;
    }
}
