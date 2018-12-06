package FunctionLayer.Calculators;

import FunctionLayer.Carport;
import FunctionLayer.Exceptions.DataException;
import FunctionLayer.Material;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Mark
 */
public class Calculator {

    private List<Material> listOfRoofMaterials;
    private List<Material> listOfScrewsMaterials;
    private List<Material> listOfScrew2Materials;
    private List<Material> listOfShedPoleMaterials;
    private List<Material> listOfShedCladdingMaterials;
    private List<Material> listOfShedWoodCladdingMaterials;
    private List<Material> listOfCarportPoleMaterials;
    private List<Material> listOfCarportStrapsMaterials;
    private List<Material> listOfCarportRaftersMaterials;
    private LinkedHashMap<String, List<Material>> HMOfAllLists = new LinkedHashMap();
    private int length;
    private int width;
    private int shedWidth;
    private int shedLength;
    private boolean tag;
    private Carport carport;

    /**
     * Contructs a calculator object, with lists of material used to build the
     * carport
     *
     *
     * @param carport
     * @param materials
     * @return Calculator object
     * @throws DataException
     */
    public Calculator(Carport carport, List<Material> materials) throws DataException {
        this.carport = carport;
        length = carport.getLength();
        width = carport.getWidth();
        shedLength = carport.getShedLength();
        shedWidth = carport.getShedWidth();
        tag = carport.isRoofChosen();
        listOfRoofMaterials = new CalculateRoof().CalculateRoofPlates(materials, length, width, tag);
        listOfScrewsMaterials = new CalculateScrews().calculateScrewsClass(materials, length, width, tag, listOfRoofMaterials);
        listOfScrew2Materials = new CalculateScrews().calculateStainlessSteel(materials, length, width, tag);
        listOfCarportPoleMaterials = new CalculateSkeleton().calculatePoles(materials, length, width);
        listOfCarportStrapsMaterials = new CalculateSkeleton().calculateStraps(materials, length);
        if (carport.isShedChosen()) {
            listOfShedPoleMaterials = new CalculateShed().calculatePoles(materials, shedLength, shedWidth, width);
            listOfShedCladdingMaterials = new CalculateShed().calculateCladding(materials, shedLength, shedWidth);
            listOfShedWoodCladdingMaterials = new CalculateShed().calculateWoodForCladding(materials, shedLength, shedWidth);
        }
        listOfCarportRaftersMaterials = new CalculateSkeleton().calculateRafters(materials, length, width);
    }

    public List<Material> getListOfRoofMaterials() {
        return listOfRoofMaterials;
    }

    public List<Material> getListOfScrewsMaterials() {
        return listOfScrewsMaterials;
    }

    public List<Material> getListOfScrew2Materials() {
        return listOfScrew2Materials;
    }

    public List<Material> getListOfShedPoleMaterials() {
        return listOfShedPoleMaterials;
    }

    public List<Material> getListOfShedCladdingMaterials() {
        return listOfShedCladdingMaterials;
    }

    public List<Material> getListOfShedWoodCladdingMaterials() {
        return listOfShedWoodCladdingMaterials;
    }

    public List<Material> getListOfCarportPoleMaterials() {
        return listOfCarportPoleMaterials;
    }

    public List<Material> getListOfCarportStrapsMaterials() {
        return listOfCarportStrapsMaterials;
    }

    public List<Material> getListOfCarportRaftersMaterials() {
        return listOfCarportRaftersMaterials;
    }

    public HashMap<String, List<Material>> getHMOfAllLists() {
        return HMOfAllLists;
    }

    /**
     * Combines all the lists representing each material and constructs a HashMap
     *
     */
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
    
    /**
     * Returns a list a constructed carport object, containing all materials and measurements
     *
     *
     * @return Carport
     */
    public Carport getCalculatedCarport() {
        combineLists();
        carport.setListOfLists(HMOfAllLists);
        return carport;
    }

}
