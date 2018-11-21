/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.List;

/**
 *
 * @author Christian
 */
public class CalculateRoof {

    public static void CalculateRoofPlates(int length, int width, List<Materiale> list, boolean tag) throws LoginSampleException {
        List<Materiale> listofRoofPlates = LogicFacade.listOfMaterialsByType("tagplader");
        int RaftersAmount = calculateRaftersAmount(length, width);
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
            list.add(listofRoofPlates.get(IndexX));
            IndexX++;
        }
        //throw new LoginSampleException("saveLength: " + saveLength + " amount: " + listofRoofPlates.get(IndexX - 1).getAmount() +  " raftersamount: " + RaftersAmount);
        if (saveLength > 0 && saveLength < iLength) {
            list.get(list.size() - 1).addToAmount(- 1);
        } else if (saveLength > 0 && IndexX == listofRoofPlates.size()) {
            while (saveLength > 0) {
                saveLength -= listofRoofPlates.get(listofRoofPlates.size() - 1).getLength();
                listofRoofPlates.get(listofRoofPlates.size() - 1).addToAmount(1);
            }
            if (listofRoofPlates.get(listofRoofPlates.size() - 1).getAmount() % 2 != 0) {
                listofRoofPlates.get(listofRoofPlates.size() - 1).addToAmount(1);
            }
            //throw new LoginSampleException("amount: " + listofRoofPlates.get(listofRoofPlates.size() - 1).getAmount());
            /*
            listofRoofPlates.get(listofRoofPlates.size() - 1).addToAmount((listofRoofPlates.get(listofRoofPlates.size() - 1).getAmount() / 6) * 2);
            int index = list.indexOf(listofRoofPlates.get(listofRoofPlates.size() - 1));
            if (index == -1) {
                list.add(listofRoofPlates.get(listofRoofPlates.size() - 1));
            } else {
                list.get(index).addToAmount((listofRoofPlates.get(listofRoofPlates.size() - 1).getAmount() / 6) * 2);
            }
             */
        }
    }

    public static int calculateRaftersAmount(int length, int width) throws LoginSampleException {
        int countReturn = 0;
        int iWidth = width;
        double coverPiece = length / 55;
        int amountOfPieces = 0;
        if (coverPiece != (double) length / 55) {
            amountOfPieces = length / 55 + 1;
        } else {
            amountOfPieces = length / 55;
        }
        List<Materiale> listOfMaterials = LogicFacade.listOfMaterialsByType("spærtræ");
        for (Materiale materiale : listOfMaterials) {
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
                Materiale lastMateriale = listOfMaterials.get(listOfMaterials.size() - 1);
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
