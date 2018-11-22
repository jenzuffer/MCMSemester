package PresentationLayer;

import FunctionLayer.Carport;
import FunctionLayer.Materiale;

/**
 *
 * @author Mark
 */
public class SVGofCarport {

    public String carport(Carport carport) {
        StringBuilder sb = new StringBuilder();
        sb.append("<rect x='0' y='0' width='100%' height='100%' style=\"stroke:#000000; fill:#ffffff;\"/>\n");
        sb.append("<rect x='50' y='50' width='").append(carport.getLength()).append("' height='").append(carport.getWidth()).append("' style=\"stroke:#000000; fill:#ffffff;\"/>\n");

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
        sb.append(LinesVertical(carport.getLength(), carport.getWidth()));
        return sb.toString();
    }

    public String placePoles(int length, int side, int width) {
        length += 100;
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

    public String LinesVertical(int length, int width) {
        StringBuilder str = new StringBuilder();
        int linesDistance = 50;
        int distance = linesDistance;
        width += 50;
        while (distance < length) {
            distance += linesDistance;
            str.append("<line x1='").append(distance).append("' x2='").append(distance).append("' y1='").append(width).append(""
                    + "' y2='50' stroke='black'/>");
        }
        if (length % linesDistance != 0) {
            length += 50;
            str.append("<line x1='").append(length).append("' x2='").append(length).append("' y1='").append(width).append(""
                    + "' y2='50' stroke='black'/>");
        }
        return str.toString();
    }

    /*
    public String placeRafters(CarportDimensioner carport) {
        return "";
    }
     */
    public static void main(String[] args) {
        SVGofCarport test = new SVGofCarport();
        String f = test.carport(new Carport(600, 300));
        System.out.println(f);
    }

}
