package FunctionLayer;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Materiale> list = new ArrayList();

    public CarportDimensioner calculate(int length, int width, boolean tag) throws LoginSampleException {
        //list.add(calculatePoles(length));
        //list.add(calculateStraps(length));
        calculateRafters(length, width);
        //calculateScrews(length, width);
        //list.add(calculateRoof(length, width));
        return new CarportDimensioner(length, width, list);
    }

    public Materiale calculatePoles(int length) {
        // Kald til DM metode til at få en liste tilbage på baggrund af type 
        //(type bliver definereret her (f.eks. "træ" fordi vi ved at det skal bruges til poles))
        // listen ville være soteret efter størst længde og heraf kan vi løbe igennem den 
        // og trække fra efterhånden vi har brug for mindre træ)

        // -100 pga. fjernelse til udhæng 
        int newlength = length - 100;

        int poles = 4;

        if (newlength > 300) {
            return new Materiale("97x97mm. trykimp. Stolpe",
                    "stolper nedgraves 90 cm. i jord", "stk", poles + 2, 300);

        } else {
            return new Materiale("97x97mm. trykimp. Stolpe",
                    "stolper nedgraves 90 cm. i jord", "stk", poles, 300);
        }
    }

    public Materiale calculateStraps(int length) {
        if (length <= 300) {
            return new Materiale("45x195mm. spærtræ ubh.", "remme", "stk", 1, 600);
        }
        if (length <= 600) {
            return new Materiale("45x195mm. spærtræ ubh.", "remme", "stk", 2, 600);
        } else {
            return new Materiale("45x195mm. spærtræ ubh.", "remme", "stk", 3, 600);
        }
    }

    public void calculateRafters(int length, int width) throws LoginSampleException {

        int iWidth = width;
        int iLength = length;
        int amountOfPieces = length / 55;

        List<Materiale> listOfWood = LogicFacade.listOfMaterialsByType("spærtræ");
        for (Materiale materiale : listOfWood) {

            System.out.println(iWidth);
            System.out.println(materiale.getLength());
            // gør ting
            if (iWidth >= materiale.getLength()) {
                materiale.addToAmount(amountOfPieces);
                iWidth = iWidth - materiale.getLength();
            }
            System.out.println(iWidth);
            System.out.println();

            int count = 0;
            if (materiale.getAmount() > 0) {
                for (; count < iWidth * amountOfPieces / materiale.getLength(); count++) {
                    materiale.addToAmount(1);
                }
                if (materiale == listOfWood.get(listOfWood.size() - 1)) {
                    materiale.addToAmount(1);
                }
            }

            // slut
            //materiale.addToAmount(countOfPiecesToAdd);
            if (materiale.getAmount() > 0) {
                list.add(materiale);
            }
            if (iWidth * amountOfPieces < listOfWood.get(listOfWood.size() - 1).getLength()) {
                Materiale lastMateriale = listOfWood.get(listOfWood.size() - 1);
                lastMateriale.addToAmount(1);
                list.add(lastMateriale);
                break;
            }
        }
    }

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
