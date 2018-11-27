package presentation;

import FunctionLayer.Carport;
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

    @Test
    public void CrossLinesTest() {
        int length = 0;
        int width = 0;
        String crossline = SVGofCarport.CrossLines(length, width);
        assertEquals(crossline, "<line x1='105' x2='0.0' y1='0' y2='50' stroke='black'/>");
    }

    /*
    @Test
    public void CrossLinesWithShedTest() {
        //selve beregningen er ikke færdig pt, så den vil fejle
        int length = 0;
        int width = 0;
        int shedlength = 0;
        int shedWidth = 0;
        String testshed = SVGofCarport.CrossLinesWithShed(length, width, shedlength, shedWidth);
        assertEquals(testshed, "not implemented yet");
    }
*/
    
    @Test
    public void LinesVerticalTest() {
        
        int length = 500;
        int width = 600;
        String test = SVGofCarport.LinesVertical(length, width);
        //alle linjer på sider, 
        assertEquals(test, "<line x1='100' x2='100' y1='650' y2='50' stroke='black'/><line x1='150' x2='150' y1='650' y2='50' stroke='black'/><line x1='200' x2='200' y1='650' y2='50' stroke='black'/><line x1='250' x2='250' y1='650' y2='50'"
                + " stroke='black'/><line x1='300' x2='300' y1='650' y2='50' stroke='black'/><line x1='350' x2='350' y1='650' y2='50' stroke='black'/><line x1='400' x2='400' y1='650' y2='50' stroke='black'/><line x1='450' x2='450' y1='650' y2='50'"
                + " stroke='black'/><line x1='500' x2='500' y1='650' y2='50' stroke='black'/>");
    }

    /*
    denne her ville nok være meget langt at teste
    @Test
    public void carportTest() {
        int length = 300;
        int width = 390;
        String test = SVGofCarport.carport(new Carport(length, width));
        assertEquals(test, "");
    }
    */
}
