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

    public SVGofCarport(CarportDimensioner carport, int svgDimensionX, int svgDimensionY) {
        this.carport = carport;
        this.svgDimensionX = svgDimensionX;
        this.svgDimensionY = svgDimensionY;
    }

    
    
    
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
        return "";
    }
    
    public String placeRafters() {
        return "";
    }

}
