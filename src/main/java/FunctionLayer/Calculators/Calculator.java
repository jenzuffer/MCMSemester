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
     * constructor to set all local variables for use
     *
     * @param materials materials required for the carport
     * @param carport required for calculations
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

    /**
     * Materials related to the roof 
     * @return listOfRoofMaterials Materials required for calculating the roof
     */
    public List<Material> getListOfRoofMaterials() {
        return listOfRoofMaterials;
    }

    /**
     * First List of Materials related to screws
     * @return listOfScrewsMaterials Materials required for calculating Screws
     */
    public List<Material> getListOfScrewsMaterials() {
        return listOfScrewsMaterials;
    }

    /**
     * Second List of Materials related to screws
     * @return listOfScrew2Materials Materials required for calculating Screws2
     */
    public List<Material> getListOfScrew2Materials() {
        return listOfScrew2Materials;
    }

    /**
     * Retrieving required amount of poles based on if the shed is included/ excluded
     * @return listOfShedPoleMaterials Materials required for calculating poles
     * based on the shed
     */
    public List<Material> getListOfShedPoleMaterials() {
        return listOfShedPoleMaterials;
    }

    /**
     * Materials required for cladding the shed
     * @return listOfShedCladdingMaterials Materials required for calculating
     * cladding based on the shed
     */
    public List<Material> getListOfShedCladdingMaterials() {
        return listOfShedCladdingMaterials;
    }

    /**
     * Wood required for cladding the shed
     * @return listOfShedWoodCladdingMaterials Wood Material required for
     * cladding the shed
     */
    public List<Material> getListOfShedWoodCladdingMaterials() {
        return listOfShedWoodCladdingMaterials;
    }

    /**
     * Calculation of poles based on the shed
     * @return listOfCarportPoleMaterials Materials required for calculating
     * poles based on the shed
     */
    public List<Material> getListOfCarportPoleMaterials() {
        return listOfCarportPoleMaterials;
    }

    /**
     * Strap Materials required for carport
     * @return listOfCarportStrapsMaterials Strap Materials required for carport
     */
    public List<Material> getListOfCarportStrapsMaterials() {
        return listOfCarportStrapsMaterials;
    }

    /**
     * Rafter Materials required for carport
     * @return listOfCarportRaftersMaterials Rafter Materials required for carport
     */
    public List<Material> getListOfCarportRaftersMaterials() {
        return listOfCarportRaftersMaterials;
    }

    /**
     * Organizing all materials in the list through a HashMap
     * @return HMOfAllLists HashMap(linkedHashmap to keep structure) Organizing all materials in the list
     */
    public HashMap<String, List<Material>> getHMOfAllLists() {
        return HMOfAllLists;
    }

    /**
     * Combines all the lists representing each material and constructs a
     * HashMap
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
     * Returns a list a constructed carport object, containing all materials and
     * measurements
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
