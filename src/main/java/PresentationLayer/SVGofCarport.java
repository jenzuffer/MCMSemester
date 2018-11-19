/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.CarportDimensioner;

/**
 *
 * @author Mark
 */
public class SVGofCarport {

    private int svgDimensionX;
    private int svgDimensionY;
    private int length;
    private int width;
    private String finalResult = "";

    // tag imod canvas størrelse og carportdimension objekt
    // find dimensioner af materialer i databasen / find dem i caportdimensioner via en liste. 
    
    
    // TODO: måske skal vi hente og gemme materialerne i listen med lidt mere info fra DB.
    // ellers bliver det svært at filtrere det og vide hvad vi skal bruge og hvor det skal bruges.
    public String initSVGOfCarport(int svgDimensionX, int svgDimensionY, CarportDimensioner carport) {
        this.svgDimensionX = svgDimensionX;
        this.svgDimensionY = svgDimensionY;
        
        
        
        // lav SVG kode her og sæt det ind som en string. Dette ville automatisk blive overført til SWGworkshop JSP'en
        // som er inkluderet i itemList.jsp for nu.
        
        finalResult +="";
        
        
        return finalResult;
    }

}
