package FunctionLayer;

import java.util.ArrayList;
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
    private List<List<Materiale>> ListOfAllLists = new ArrayList();
    private int length;
    private int width;
    private int shedWidth;
    private int shedLength;
    private boolean tag;
    private Carport carport;
    
    public Calculator(Carport carport) throws LoginSampleException {
        this.carport = carport;
        length = carport.getLength();
        width = carport.getWidth();
        shedLength = carport.getShedLength();
        shedWidth = carport.getShedWidth();
        tag = carport.isRoofChosen();
        listOfRoofMaterials = new CalculateRoof().CalculateRoofPlates(length, width, tag);
        listOfScrewsMaterials = new CalculateScrews().calculateScrewsClass(length, width, tag, listOfRoofMaterials);
        listOfScrew2Materials = new CalculateScrews().calculateStainlessSteel(length, width, tag);
        listOfShedPoleMaterials = new CalculateShed().calculatePoles(shedLength, shedWidth, width);
        listOfShedCladdingMaterials = new CalculateShed().calculateCladding(length, width);
        listOfShedWoodCladdingMaterials = new CalculateShed().calculateWoodForCladding(length, width);
        listOfCarportPoleMaterials = new CalculateSkeleton().calculatePoles(length, width); 
        listOfCarportStrapsMaterials = new CalculateSkeleton().calculateStraps(length);
        listOfCarportRaftersMaterials = new CalculateSkeleton().calculateRafters(length, width);
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

    public List<List<Materiale>> getListOfAllLists() {
        return ListOfAllLists;
    }
    
    public void combineLists() {
        ListOfAllLists.add(listOfCarportPoleMaterials);
        ListOfAllLists.add(listOfCarportRaftersMaterials);
        ListOfAllLists.add(listOfCarportStrapsMaterials);
        ListOfAllLists.add(listOfRoofMaterials);
        ListOfAllLists.add(listOfScrew2Materials);
        ListOfAllLists.add(listOfScrewsMaterials);
        ListOfAllLists.add(listOfShedCladdingMaterials);
        ListOfAllLists.add(listOfShedPoleMaterials);
        ListOfAllLists.add(listOfShedWoodCladdingMaterials);
    }
    
    
    public Carport getCalculatedCarport() {
        combineLists(); 
        carport.setListOfLists(ListOfAllLists);
        return carport;
    }
    
}




