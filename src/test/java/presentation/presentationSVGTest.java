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
}
