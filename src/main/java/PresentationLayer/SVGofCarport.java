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
                if (j == 0) {
                    sb.append(placePoles(100+(j * (carport.getLength() / (x - 1) - 100 / x)), i, carport.getWidth()));
                } else {
                    sb.append(placePoles(100+(j * (carport.getLength() / (x - 1) - 100 / (x-1))), i, carport.getWidth()));
                }
                
                
            }
        }
        // sb.append(placeRafters(carport));
        sb.append(LinesVertical(carport.getLength(), carport.getWidth()));
        /*
        if (carport.isShedChosen()) {
            sb.append(CrossLinesWithShed(carport.getLength(), carport.getWidth(), carport.getShedLength(), carport.getShedWidth()));
        } else {
            sb.append(CrossLines(carport.getLength(), carport.getWidth()));
        }
         */
        sb.append(placeStraps(carport.getLength(), carport.getWidth()));
        return sb.toString();
    }

    public String placePoles(int length, int side, int width) {
        //length += 100;
        String pole = "";
        int saveWidth = width;
        if (side % 2 == 0) {
            pole = "<rect x='" + (length + 50 - 10) + "' y='" + (saveWidth * side + 80 - 10) + "' width='20' height='20' style=\"stroke:#000000; fill:#ffffff;\"/>\n";
        } else {
            pole = "<rect x='" + (length + 50 - 10) + "' y='" + (saveWidth * side + 20 - 10) + "' width='20' height='20' style=\"stroke:#000000; fill:#ffffff;\"/>\n";
        }
        return pole;
    }

    public String placeStraps(int length, int width) {
        StringBuilder str = new StringBuilder();
        width += 50;
        int DistanceToWidth = width - 30;
        str.append("<line y1='").append(DistanceToWidth).append("' y2='").append(DistanceToWidth).append("'"
                + "x2='").append(50).append("' x1='").append(length + 50).append("' stroke='black'/>");
        str.append("<line y1='").append(50 + 30).append("' y2='").append(50 + 30).append("'"
                + "x2='").append(50).append("' x1='").append(length + 50).append("' stroke='black'/>");
        return str.toString();
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

    public String CrossLines(int length, int width) {
        StringBuilder str = new StringBuilder();
        int linesDistanceInitial = 105;
        str.append("<line x1='").append(linesDistanceInitial).append("' x2='").append((length - (length * 0.70))).append("' y1='").append(width).append(""
                + "' y2='50' stroke='black'/>");
        return str.toString();
    }

    public String CrossLinesWithShed(int length, int width, int shedLength, int shedWidth) {
        StringBuilder str = new StringBuilder();
        int linesDistanceInitial = 105;

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
