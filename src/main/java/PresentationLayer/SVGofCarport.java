package PresentationLayer;

import FunctionLayer.CarportDimensioner;
import FunctionLayer.Materiale;

/**
 *
 * @author Mark
 */
public class SVGofCarport {

    public String carport(CarportDimensioner carport) {
        StringBuilder sb = new StringBuilder();
        sb.append("<rect x='0' y='0' width='100%' height='100%' style=\"stroke:#000000; fill:#ffffff;\"/>\n");
        sb.append("<rect x='50' y='50' width='" + carport.getLength() + "' height='" + carport.getWidth() + "' style=\"stroke:#000000; fill:#ffffff;\"/>\n");

        int length = carport.getLength();
        int x = 1;

        while (length > 0) {
            x++;
            length -= 300;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < x; j++) {
                sb.append(placePoles(j * (carport.getLength() / (x - 1)), i, carport.getWidth()));
            }
        }
        // sb.append(placeRafters(carport));
        return sb.toString();
    }

    public String placePoles(int length, int side, int width) {
        String pole = "";
        if (side % 2 == 0) {
            pole = "<rect x='" + (length + 50 - 10) + "' y='" + (width * side + 50 - 10) + "' width='20' height='20' style=\"stroke:#000000; fill:#ffffff;\"/>\n";
        } else {
            pole = "<rect x='" + (length + 50 - 10) + "' y='" + (width * side + 50 - 10) + "' width='20' height='20' style=\"stroke:#000000; fill:#ffffff;\"/>\n";
        }
        return pole;
    }

    public String placeStraps() {
        return "";
    }

    /*
    public String placeRafters(CarportDimensioner carport) {
        return "";
    }
     */
    public static void main(String[] args) {
        SVGofCarport test = new SVGofCarport();
        String f = test.carport(new CarportDimensioner(600, 300));
        System.out.println(f);
    }

}
