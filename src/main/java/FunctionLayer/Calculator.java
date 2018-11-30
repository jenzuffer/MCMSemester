package FunctionLayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Mark
 */
public class Calculator {
    private List<Materiale> listOfRoofMaterials;
    private List<Materiale> listOfScrewsMaterials;
    private List<Materiale> listOfScrew2Materials;
    private List<Materiale> listOfShedPoleMaterials;
    private List<Materiale> listOfShedCladdingMaterials;
    private List<Materiale> listOfShedWoodCladdingMaterials;
    private List<Materiale> listOfCarportPoleMaterials;
    private List<Materiale> listOfCarportStrapsMaterials;
    private List<Materiale> listOfCarportRaftersMaterials;
    private LinkedHashMap<String,List<Materiale>> HMOfAllLists = new LinkedHashMap();
    private int length;
    private int width;
    private int shedWidth;
    private int shedLength;
    private boolean tag;
    private Carport carport;
    
    public Calculator(Carport carport, List<Materiale> materials) throws LoginSampleException {
        this.carport = carport;
        length = carport.getLength();
        width = carport.getWidth();
        shedLength = carport.getShedLength();
        shedWidth = carport.getShedWidth();
        tag = carport.isRoofChosen();
        listOfRoofMaterials = new CalculateRoof().CalculateRoofPlates(materials, length, width, tag);
        listOfScrewsMaterials = new CalculateScrews().calculateScrewsClass(materials, length, width, tag, listOfRoofMaterials);
        listOfScrew2Materials = new CalculateScrews().calculateStainlessSteel(materials,length, width, tag);
        listOfCarportPoleMaterials = new CalculateSkeleton().calculatePoles(materials,length, width); 
        listOfCarportStrapsMaterials = new CalculateSkeleton().calculateStraps(materials,length);
        if (carport.isShedChosen()) {
            listOfShedPoleMaterials = new CalculateShed().calculatePoles(materials,shedLength, shedWidth, width);
            listOfShedCladdingMaterials = new CalculateShed().calculateCladding(materials,shedLength, shedWidth);
            listOfShedWoodCladdingMaterials = new CalculateShed().calculateWoodForCladding(materials,shedLength, shedWidth);
        }
        listOfCarportRaftersMaterials = new CalculateSkeleton().calculateRafters(materials,length, width);
    }

    public List<Materiale> getListOfRoofMaterials() {
        return listOfRoofMaterials;
    }

    public List<Materiale> getListOfScrewsMaterials() {
        return listOfScrewsMaterials;
    }

    public List<Materiale> getListOfScrew2Materials() {
        return listOfScrew2Materials;
    }

    public List<Materiale> getListOfShedPoleMaterials() {
        return listOfShedPoleMaterials;
    }

    public List<Materiale> getListOfShedCladdingMaterials() {
        return listOfShedCladdingMaterials;
    }

    public List<Materiale> getListOfShedWoodCladdingMaterials() {
        return listOfShedWoodCladdingMaterials;
    }

    public List<Materiale> getListOfCarportPoleMaterials() {
        return listOfCarportPoleMaterials;
    }

    public List<Materiale> getListOfCarportStrapsMaterials() {
        return listOfCarportStrapsMaterials;
    }

    public List<Materiale> getListOfCarportRaftersMaterials() {
        return listOfCarportRaftersMaterials;
    }

    public HashMap<String, List<Materiale>> getHMOfAllLists() {
        return HMOfAllLists;
    }

    
    public void combineLists() {
        HMOfAllLists.put("carportpoles", listOfCarportPoleMaterials);
        HMOfAllLists.put("caportrafters", listOfCarportRaftersMaterials);
        HMOfAllLists.put("caportstraps", listOfCarportStrapsMaterials);
        HMOfAllLists.put("roof", listOfRoofMaterials);
        HMOfAllLists.put("screws", listOfScrew2Materials);
        HMOfAllLists.put("screws2", listOfScrewsMaterials);
        if (carport.isShedChosen()) {
            HMOfAllLists.put("shedcladding", listOfShedCladdingMaterials);
            HMOfAllLists.put("shedpole", listOfShedPoleMaterials);
            HMOfAllLists.put("shedwoodcladding", listOfShedWoodCladdingMaterials);
            
        }
    }
    
    
    public Carport getCalculatedCarport() {
        combineLists(); 
        carport.setListOfLists(HMOfAllLists);
        return carport;
    }
    
}




