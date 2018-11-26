package presentation;

import PresentationLayer.SVGofCarport;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Christian
 */
public class presentationSVGTest {

    @Test
    public void placePolesTest() {

        int length = 0;
        int side = 1;
        int width = 0;
        String poleTest = SVGofCarport.placePoles(length, side, width);
        //return poleTest;
        assertEquals(poleTest, "<rect x='40' y='10' width='20' height='20' style=\"stroke:#000000; fill:#ffffff;\"/>\n");
        length += 50;
        side = 2;
        width += 50;
        poleTest = SVGofCarport.placePoles(length, side, width);
        assertEquals(poleTest, "<rect x='90' y='170' width='20' height='20' style=\"stroke:#000000; fill:#ffffff;\"/>\n");
    }

    @Test
    public void placeStraps() {
        int length = 80;
        int width = 240;
        String Straps = SVGofCarport.placeStraps(length, width);
        assertEquals(Straps, "<line y1='260' y2='260'"
                + "x2='50' x1='130' stroke='black'/><line y1='80' y2='80'"
                + "x2='50' x1='130' stroke='black'/>");
        length += 60;
        width += 40;
        Straps = SVGofCarport.placeStraps(length, width);
        assertEquals(Straps, "<line y1='300' y2='300'"
                + "x2='50' x1='190' stroke='black'/><line y1='80' y2='80'"
                + "x2='50' x1='190' stroke='black'/>");
    }
}
