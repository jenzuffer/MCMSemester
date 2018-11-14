package FunctionLayer;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Materiale> list = new ArrayList();

    public CarportDimensioner calculate(int length, int width, boolean tag) throws LoginSampleException {
        list.add(calculatePoles(length));
        list.add(calculateStraps(length));
        list.add(calculateRafters(length, width));
        list.add(calculateRoof(length, width));
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

    public Materiale calculateRafters(int length, int width) throws LoginSampleException {
        int iLength = length;
        List<Materiale> listOfWood = LogicFacade.listOfMaterialsByType("spærtræ");
        for (Materiale materiale : listOfWood) {
            if (length > materiale.getLength()) {
                iLength -= materiale.getLength();
            }
        }

        if (width <= 300) {
            return new Materiale("45x195mm. ubh.", "spær, monteres på rem", "stk", 1 + (length / 55) / 2, 600);
        }

        return new Materiale("45x195mm. ubh.", "spær, monteres på rem", "stk", length / 55, 600);
    }

    public Materiale calculateRoof(int length, int width) {
        if (width % 600 == 0) {
            return new Materiale("plastmo ecolite blåtonet", "tagplader monteres på spær", "stk", length / 106, 600);
        } else {
            // antal plader på 6 meter og et andet sæt på minimums længde
            return new Materiale("plastmo ecolite blåtonet", "tagplader monteres på spær", "stk", (length / 106) * 2, 600);
//          lav en liste af materialer
//          return length/106*2;
        }

    }

}
