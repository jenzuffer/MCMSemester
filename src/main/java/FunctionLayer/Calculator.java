package FunctionLayer;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Materiale> list = new ArrayList();

    public CarportDimensioner calculate(int length, int width, boolean tag) throws LoginSampleException {
        calculatePoles(length, width);
        calculateStraps(length);
        calculateRafters(length, width);
        //calculateScrews(length, width);
        //list.add(calculateRoof(length, width));
        return new CarportDimensioner(length, width, list);
    }

    public void calculatePoles(int length, int width) throws LoginSampleException {

        int saveLength = length;
        int saveWidth = width;

        List<Materiale> listOfMaterials = LogicFacade.listOfMaterialsByType("stolpe");
        // poles er ikke afhængig af length eller width men af typen af carport (fladt tag eller skråtag)

        int x = 1, y = 1;

        while (saveLength > 0) {
            x = x + 1;
            saveLength = saveLength - 300;
        }
        System.out.println(x);
        while (saveWidth > 0) {
            y = y + 1;
            saveWidth = saveWidth - 450;
        }

        Materiale lastPole = listOfMaterials.get(listOfMaterials.size() - 1);
        lastPole.addToAmount(x*y);
        list.add(lastPole);
        

    }

    public void calculateStraps(int length) throws LoginSampleException {
        List<Materiale> listOfMaterials = LogicFacade.listOfMaterialsByType("spærtræ");
        int totalLength = length*2;
        
        for (Materiale Material : listOfMaterials) {
            
            
            if (totalLength / Material.getLength() > 0) {
                Material.addToAmount(totalLength / Material.getLength());
                totalLength = totalLength - ((totalLength / Material.getLength()) * Material.getLength());
                Material.setDescription("Remme i sider, sadles ned i stolper");
            }

            if (totalLength < Material.getLength() && Material == listOfMaterials.get(listOfMaterials.size()-1)) {
                Material.addToAmount(1);
            }
            
            

            if (Material.getAmount() > 0) {
                list.add(Material);
                Material.setDescription("Remme i sider, sadles ned i stolper");
            }
            
            
            
            
        }
        
        
        
        
        
    }

    public void calculateRafters(int length, int width) throws LoginSampleException {

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
                list.add(materiale);
            }

            if (iWidth <= 0) {
                break;
            }

            if (iWidth * amountOfPieces < listOfMaterials.get(listOfMaterials.size() - 1).getLength()) {
                Materiale lastMateriale = listOfMaterials.get(listOfMaterials.size() - 1);
                lastMateriale.addToAmount(1);
                if (materiale != listOfMaterials.get(listOfMaterials.size() - 1)) {
                    list.add(lastMateriale);
                }
                break;
            }
        }
    }

    /*
    public void calculateRoof(int length, int width) throws LoginSampleException {
        int iLength = length;
        int iWidthLength = length;
        int iWidthIndex = 0;
        int iWidth = 55;
        int index = 0;
        List<Materiale> listofRoof = LogicFacade.listOfMaterialsByType("tag");
        while (iWidthLength > 0) {
            iWidthIndex++;
            iWidthLength -= iWidth;
        }
        for (Materiale materiale : listofRoof) {
            //lengths
            while (iLength > materiale.getLength()) {
                materiale.setAmount(iWidthIndex);
                list.add(materiale);
                iLength -= materiale.getLength();
            }
        }
        if (iLength > 0) {
            for (int i = 0; i < listofRoof.size(); i++) {
                if (iLength > listofRoof.get(i).getLength()) {
                    index = i;
                    break;
                }
            }
            if (index == 0) {
                index = listofRoof.size() - 1;
            }
            listofRoof.get(index).setAmount(iWidthIndex);
            list.add(listofRoof.get(index));
        }
    }
     */
    public void calculateScrews(int length, int width) throws LoginSampleException {
        List<Materiale> listofScrews = LogicFacade.listOfMaterialsByType("bundskruer");
        for (Materiale materiale : listofScrews) {
            materiale.addToAmount(1);
            list.add(materiale);
        }
    }

    public void fixMaterialsInList() throws LoginSampleException {

    }

}
