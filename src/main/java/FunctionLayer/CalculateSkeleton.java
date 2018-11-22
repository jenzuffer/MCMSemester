package FunctionLayer;

import java.util.ArrayList;
import java.util.List;

public class CalculateSkeleton {

    private List<Materiale> list = new ArrayList();
    private List<List> testlist = new ArrayList();

    public CarportDimensioner calculate(int length, int width, int shedLength, int shedWidth, boolean tag) throws LoginSampleException {
        calculatePoles(length, width);
        calculateStraps(length);
        calculateRafters(length, width);
        list = CalculateScrews.calculateScrewsclass(length, width, tag);
        testlist.add(list);
        CalculateShed.calculatePoles(shedLength, shedWidth, width, list);
        CalculateShed.calculateCladding(shedLength, shedWidth, list);
        CalculateShed.calculateWoodForCladding(shedLength, shedWidth, list);
        list = CalculateRoof.CalculateRoofPlates(length, width, tag);
        testlist.add(list);
        return new CarportDimensioner(length, width, list);
    }

    public void calculatePoles(int length, int width) throws LoginSampleException {

        int saveLength = length;
        int saveWidth = width;

        List<Materiale> listOfMaterials = LogicFacade.listOfMaterialsByType("stolpe");
        // poles er ikke afhængig af length eller width men af typen af carport (fladt tag eller skråtag)

        int x = 1, y = 1;

        while (saveLength > 0) {
            x++;
            saveLength -= 300;
        }
        System.out.println(x);
        while (saveWidth > 0) {
            y++;
            saveWidth -= 450;
        }

        Materiale lastPole = listOfMaterials.get(listOfMaterials.size() - 1);
        lastPole.addToAmount(x * y);
        list.add(lastPole);

    }

    public void calculateStraps(int length) throws LoginSampleException {
        List<Materiale> listOfMaterials = LogicFacade.listOfMaterialsByType("spærtræ");
        int totalLength = length * 2;

        for (Materiale Material : listOfMaterials) {

            if (totalLength / Material.getLength() > 0) {
                Material.addToAmount(totalLength / Material.getLength());
                totalLength = totalLength - ((totalLength / Material.getLength()) * Material.getLength());
                Material.setDescription("Remme i sider, sadles ned i stolper");
            }

            if (totalLength < Material.getLength() && Material == listOfMaterials.get(listOfMaterials.size() - 1)) {
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

    public void fixMaterialsInList() throws LoginSampleException {

    }

}
