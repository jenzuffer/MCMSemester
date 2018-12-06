/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer.Calculators;

import FunctionLayer.Exceptions.DataException;
import FunctionLayer.LogicFacade;
import FunctionLayer.Material;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class CalculateScrews {

    /**
     * Returns a list of material object representing the number of screws used
     * for the carport
     *
     * This method calculates the number of screws
     *
     * @param materials list of object
     * @param length int length
     * @param width int width
     * @param tag boolean related to roof
     * @param listOfRoofMaterials list of objects related to roof
     * @return List of screws
     * @throws DataException through LogicFacade
     */
    public List<Material> calculateScrewsClass(List<Material> materials, int length, int width, boolean tag, List<Material> listOfRoofMaterials) throws DataException {
        List<Material> returnlist = new ArrayList();

        List<Material> listofScrews = LogicFacade.listOfMaterialsByType("bundskruer");
        /*
        for (Materiale material : materials) {
            if ("bundskruer".equals(material.getType())) {
                listofScrews.add(material);
            }
        }
         */
        int amount = 0;
        List<Material> roofMaterialsForScrews;
        roofMaterialsForScrews = listOfRoofMaterials;
        for (int i = 0; i < roofMaterialsForScrews.size(); i++) {
            amount += roofMaterialsForScrews.get(i).getAmount();
        }
        for (Material screwMaterials : listofScrews) {
            screwMaterials.addToAmount(amount / 2);
            returnlist.add(screwMaterials);
        }
        return returnlist;
    }

    /**
     * Returns a list of material object representing the number of steel used
     * for the carport
     *
     * This method calculates the number of steel
     *
     * @param materials list of object
     * @param length int length
     * @param width int width
     * @param tag boolean tag
     * @return List of steel
     * @throws DataException from LogicFacade
     */
    public List<Material> calculateStainlessSteel(List<Material> materials, int length, int width, boolean tag) throws DataException {
        List<Material> returnlist = new ArrayList();
        List<Material> listofStainlessSteal = LogicFacade.listOfMaterialsByType("hulbånd");

        /*
        for (Materiale material : materials) {
            if ("hulbånd".equals(material.getType())) {
                listofStainlessSteal.add(material);
            }
        }
         */
        if (tag) {
            for (Material screwMaterials : listofStainlessSteal) {
                screwMaterials.addToAmount(2);
                returnlist.add(screwMaterials);
            }
        }
        return returnlist;
    }

}
