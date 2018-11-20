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

    private CarportDimensioner carport;
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
        length = carport.getLength();
        width = carport.getWidth();
        this.carport = carport;
        
        
        
        finalResult = "";
        
    
        return finalResult;
    }
    
    
    
    public String placePoles() {
        /*
        på baggrund af carportens længde / antal af materialer til rådighed for stolper, 
        dividere carportens længde med antal af stolper minus 1 og placer dem ved hver division
        f.eks. 360 cm / 3(-1) stolper = 1 stolpe per 180 cm startende fra og til; 0, 180, 360
       
        
        */
        return "";
    }
    
    public String placeRafters() {
        return "";
    }

}
