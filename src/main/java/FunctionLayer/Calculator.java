package FunctionLayer;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private List<Materiale> list = new ArrayList();
    
    public CarportDimensioner calculate(int length, int width, boolean tag) {
        list.add(calculatePoles(length));
        list.add(calculateStraps(length));
        list.add(calculateRafters(length, width));
        list.add(calculateRoof(length, width));
        return new CarportDimensioner(length, width, list);
    }

    public Materiale calculatePoles(int length) {
        // fjernelse til udhæng 
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
        } 
        else {
            return new Materiale("45x195mm. spærtræ ubh.", "remme", "stk", 3, 600);
        }
    }

    public Materiale calculateRafters(int length, int width) {
        if (width <= 300) {
            return new Materiale("45x195mm. ubh.", "spær, monteres på rem", "stk", 1 + (length / 55) / 2, 600);
        }
        
        return new Materiale("45x195mm. ubh.", "spær, monteres på rem", "stk", length / 55, 600);
    }
    
    
    public Materiale calculateRoof(int length, int width) {
        if (width % 600 == 0) {
            return new Materiale("plastmo ecolite blåtonet", "tagplader monteres på spær", "stk", length/106, 600);
        } else {
            // antal plader på 6 meter og et andet sæt på minimums længde
            return new Materiale("plastmo ecolite blåtonet", "tagplader monteres på spær", "stk", (length/106)*2, 600);
//          lav en liste af materialer
//          return length/106*2;
        }
        
    }
    
    

}
