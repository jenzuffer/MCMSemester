package PresentationLayer;

import FunctionLayer.Carport;
import FunctionLayer.LoginSampleException;

/**
 *
 * @author Mark
 */
public class SVGofCarport {

    public static String carport(Carport carport) throws LoginSampleException {
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
                    sb.append(placePoles(100 + (j * (carport.getLength() / (x - 1) - 100 / x)), i, carport.getWidth()));

                } else {
                    if (j + 1 == x) {
                        sb.append(placePoles(100 + (j * (carport.getLength() / (x - 1) - 100 / (x - 1))), i, carport.getWidth()));
                    }
                    sb.append(placePoles(100 + (j * (carport.getLength() / (x - 1) - 100 / (x - 1))), i, carport.getWidth()));
                }
            }
        }
        // sb.append(placeRafters(carport));
        if (!carport.isRoofChosen()) {
            sb.append(LinesVertical(carport.getLength(), carport.getWidth()));
        } else {
            sb.append(LinesVerticalRoof(carport.getLength(), carport.getWidth()));
        }
        sb.append(CrossLinesAndShed(carport.getLength(), carport.getWidth(), carport.isShedChosen(), carport.getShedLength(), carport.getShedWidth(), carport.isRoofChosen()));
        sb.append(placeStraps(carport.getLength(), carport.getWidth()));
        if (carport.isRoofChosen()) {
            sb.append(placeRoof(carport.getLength(), carport.getWidth()));
        }
        return sb.toString();
    }

    public static String placePoles(int length, int side, int width) {
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

    public static String placeStraps(int length, int width) {
        StringBuilder str = new StringBuilder();
        width += 50;
        int DistanceToWidth = width - 30;
        str.append("<line y1='").append(DistanceToWidth).append("' y2='").append(DistanceToWidth).append("'"
                + "x2='").append(50).append("' x1='").append(length + 50).append("' stroke='black'/>");
        str.append("<line y1='").append(50 + 30).append("' y2='").append(50 + 30).append("'"
                + "x2='").append(50).append("' x1='").append(length + 50).append("' stroke='black'/>");
        return str.toString();
    }

    public static String LinesVertical(int length, int width) {
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

    public static String CrossLinesAndShed(int length, int width, boolean isshedchoosen, int shedlength, int shedwidth, boolean roof) {
        StringBuilder str = new StringBuilder();
        int linesDistanceInitial = 100;
        int shedmove = 0;
        if (isshedchoosen) {
            shedmove = length - (shedlength - 30); // røkkes tættere på slutning af alle tilfælde
        } else {
            if (length > 300 && length <= 600) {
                shedmove = length - (int) (length * 0.30);
            } else if (length > 600) {
                shedmove = length - (int) (length * 0.225);
            } else {
                shedmove = length - (int) ((length * 0.25));
            }
        }
        if (!roof) {
            str.append("<line x1='").append(linesDistanceInitial).append("' x2='").append(shedmove).append("' y1='").append(width + 25).append(""
                    + "' y2='80' stroke='black'/>");
            str.append("<line x1='").append(linesDistanceInitial).append("' x2='").append(shedmove).append("' y1='80' y2='").append(width + 25).append("' stroke='black'/>");
        }
        if (isshedchoosen) {
            str.append("<line x1='").append(shedmove).append("' x2='").append(shedmove).append("' y1='").append(shedwidth + 25).append(""
                    + "' y2='80' stroke-width='3' stroke='black'/>");
            str.append("<line x1='").append((shedmove + shedlength)).append("' x2='").append((shedlength + shedmove)).append("' y1='").append(shedwidth + 25).append(""
                    + "' y2='80' stroke-width='3' stroke='black'/>");
            str.append("<line x1='").append(shedmove).append("' x2='").append((shedlength + shedmove)).append("' y1='").append(shedwidth + 25).append(""
                    + "' y2='").append(shedwidth + 25).append("' stroke-width='3' stroke='black'/>");
            str.append("<line x1='").append(shedmove).append("' stroke-width='3' x2='").append((shedlength + shedmove)).append("' y1='80' y2='80' stroke='black'/>");
        }
        return str.toString();
    }

    /*
    public String placeRafters(CarportDimensioner carport) {
        return "";
    }
     */
    public static void main(String[] args) throws LoginSampleException {
        SVGofCarport test = new SVGofCarport();
        String f = test.carport(new Carport(600, 300));
        System.out.println(f);
    }

    private static String placeRoof(int length, int width) {
        StringBuilder str = new StringBuilder();
        int linesDistanceInitial = 50;
        int savewidth = width;
        //int savewidth2 = width;
        savewidth /= 6;
        for (int i = 0; i < 6; i++) {
            str.append("<line x1='").append(linesDistanceInitial).append("' x2='").append(length + 55).append("' y1='").append((savewidth * i) + 100).append(""
                    + "' y2='").append((savewidth * i) + 100).append("' stroke-width='3' stroke='black'/>");
            str.append("<line x1='").append(linesDistanceInitial).append("' x2='").append(length + 55).append("' y1='").append((savewidth * i) + 50).append(""
                    + "' y2='").append((savewidth * i) + 50).append("' stroke-width='2' outline='white' stroke='black'/>");
        }
        return str.toString();
    }

    private static String LinesVerticalRoof(int length, int width) {
        StringBuilder str = new StringBuilder();
        int distance = 89;
        int initialDistance = 50;
        int savelegnth = length;
        int index = 0;
        while (savelegnth > distance) {
            str.append("<line x1='").append(initialDistance + (distance * index)).append("' x2='").append(initialDistance + (distance * index)).append("' y1='80' y2='").append(width).append("' stroke-width='2' stroke='black'/>");
            savelegnth -= distance;
            index++;
        }
        return str.toString();
    }

}
