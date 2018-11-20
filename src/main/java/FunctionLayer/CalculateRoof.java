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

    public static void CalculateRoofPlates(int length, List<Materiale> list, boolean tag) throws LoginSampleException {
        List<Materiale> listofRoofPlates = LogicFacade.listOfMaterialsByType("tagplader");
        int StrapsAmount = CalculateStrapsAmount(length);
        if (tag) {
            StrapsAmount *= 1.5;
        }
        int saveLength = length; //eksempel 450
        int IndexX = 0;
        int iLength = 55;
        while (saveLength > iLength && IndexX < listofRoofPlates.size()) {
            while (saveLength > listofRoofPlates.get(IndexX).getLength()) {
                saveLength -= listofRoofPlates.get(IndexX).getLength();
                listofRoofPlates.get(IndexX).addToAmount(1);
            }
            if (listofRoofPlates.get(IndexX).getAmount() > 0) {
                listofRoofPlates.get(IndexX).setDescription("tagplader der monteres på spær");
                listofRoofPlates.get(IndexX).setAmount(listofRoofPlates.get(IndexX).getAmount() * StrapsAmount);
                list.add(listofRoofPlates.get(IndexX));
            }
            IndexX++;
        }
        if (saveLength > 0 && saveLength < iLength) {
            list.get(list.size() - 1).addToAmount(1);
        } else if (saveLength > 0 && IndexX == listofRoofPlates.size()) {
            while (saveLength > 0) {
                saveLength -= listofRoofPlates.get(listofRoofPlates.size() - 1).getLength();
                listofRoofPlates.get(listofRoofPlates.size() - 1).addToAmount(1);
            }
            listofRoofPlates.get(listofRoofPlates.size() - 1).setAmount(listofRoofPlates.get(listofRoofPlates.size() - 1).getAmount() * StrapsAmount);
            int index = list.indexOf(listofRoofPlates.get(listofRoofPlates.size() - 1));
            if (index == -1) {
                list.add(listofRoofPlates.get(listofRoofPlates.size() - 1));
            } else {
                list.get(index).addToAmount(listofRoofPlates.get(listofRoofPlates.size() - 1).getAmount());
            }
        }
    }

    private static int CalculateStrapsAmount(int length) throws LoginSampleException {
        int count = 0;
        List<Materiale> listOfMaterials = LogicFacade.listOfMaterialsByType("spærtræ");
        int totalLength = length * 2;
        for (Materiale Material : listOfMaterials) {
            if (totalLength / Material.getLength() > 0) {
                Material.addToAmount(totalLength / Material.getLength());
                totalLength = totalLength - ((totalLength / Material.getLength()) * Material.getLength());
            }
            if (totalLength < Material.getLength() && Material == listOfMaterials.get(listOfMaterials.size() - 1)) {
                Material.addToAmount(1);
            }
            if (Material.getAmount() > 0) {
                count += Material.getAmount();
            }
        }
        return count;
    }
}
