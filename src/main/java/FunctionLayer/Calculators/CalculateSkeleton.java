package FunctionLayer.Calculators;

import FunctionLayer.Exceptions.DataException;
import FunctionLayer.LogicFacade;
import FunctionLayer.Material;
import java.util.ArrayList;
import java.util.List;

public class CalculateSkeleton {

    public List<Material> calculatePoles(List<Material> materials, int length, int width) throws DataException {
        List<Material> returnList = new ArrayList();
        int saveLength = length - 100;
        int saveWidth = width;

        List<Material> listOfMaterials = LogicFacade.listOfMaterialsByType("stolpe");
/*
        for (Materiale material : materials) {
            if ("stolpe".equals(material.getType())) {
                listOfMaterials.add(material);
            }
        }
*/
        int x = 1;
//        int y = 1;

        while (saveLength > 70) {
            x++;
            saveLength -= 300;
        }
//        while (saveWidth > 0) {
//            y++;
//            saveWidth -= 450;
//        }
//
//        int poles = x * y - (x * (y - 2));

        Material lastPole = listOfMaterials.get(listOfMaterials.size() - 1);
        lastPole.addToAmount(x * 2);
        returnList.add(lastPole);
        return returnList;
    }

    public List<Material> calculateStraps(List<Material> materials, int length) throws DataException {
        List<Material> returnList = new ArrayList();
        List<Material> listOfMaterials = LogicFacade.listOfMaterialsByType("spærtræ");
        int totalLength = length * 2;
/*
        for (Materiale material : materials) {
            if ("spærtræ".equals(material.getType())) {
                listOfMaterials.add(material);
            }
        }
*/
        for (Material Material : listOfMaterials) {

            if (totalLength / Material.getLength() > 0) {
                Material.addToAmount(totalLength / Material.getLength());
                totalLength = totalLength - ((totalLength / Material.getLength()) * Material.getLength());
                Material.setDescription("Remme i sider, sadles ned i stolper");
            }

            if (totalLength < Material.getLength() && Material == listOfMaterials.get(listOfMaterials.size() - 1)) {
                Material.addToAmount(1);
            }

            if (Material.getAmount() > 0) {
                returnList.add(Material);
                Material.setDescription("Remme i sider, sadles ned i stolper");
            }

        }
        return returnList;

    }

    public List<Material> calculateRafters(List<Material> materials, int length, int width) throws DataException {
        List<Material> returnList = new ArrayList();
        List<Material> listOfMaterials = LogicFacade.listOfMaterialsByType("spærtræ");
        /*
        for (Materiale material : materials) {
            if ("spærtræ".equals(material.getType())) {
                listOfMaterials.add(material);
            }
        }
        */
        int iWidth = width;
        double coverPiece = length / 55;
        int amountOfPieces = 0;
        if (coverPiece != (double) length / 55) {
            amountOfPieces = length / 55 + 1;
        } else {
            amountOfPieces = length / 55;
        }

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
                returnList.add(materiale);
            }

            if (iWidth <= 0) {
                break;
            }

            if (iWidth * amountOfPieces < listOfMaterials.get(listOfMaterials.size() - 1).getLength()) {
                Material lastMateriale = listOfMaterials.get(listOfMaterials.size() - 1);
                lastMateriale.addToAmount(1);
                if (materiale != listOfMaterials.get(listOfMaterials.size() - 1)) {
                    returnList.add(lastMateriale);
                }
                break;
            }
        }
        return returnList;
    }

    public void fixMaterialsInList() throws DataException {

    }

}
