package FunctionLayer;

public class Calculator {

    public void calculate(int length, int width, boolean tag) {
        
        
        calculatePoles(length);
        calculateRafters(length, width);
    }

    public int calculatePoles(int length) {
        // fjernelse til udhæng 
        int newlength = length - 100;

        int poles = 4;

        if (newlength > 300) {
            
            return poles + 2;
        } else {
            return poles;
        }
    }

    public int calculateStraps(int length) {
        if (length <= 300) {
            return 1;
        }
        if (length <= 600) {
            return 2;
        } 
        else {
            return 3;
        }
    }

    public int calculateRafters(int length, int width) {
        if (width <= 300) {
            return 1 + (length / 55) / 2;
        }
        return length / 55;
    }
    
    
    public int calculateRoof(int length, int width) {
        if (width % 600 == 0) {
            return length/106;
        } else {
            // antal plader på 6 meter og et andet sæt på minimums længde
            return length/106*2;
        }
        
    }
    
    

}
