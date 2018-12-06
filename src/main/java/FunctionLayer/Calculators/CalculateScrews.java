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

    //public List<Materiale> calculateScrewsClass(int length, int width, boolean tag, List<Materiale> roof) throws LoginSampleException {
    List<Material> calculateScrewsClass(List<Material> materials, int length, int width, boolean tag, List<Material> listOfRoofMaterials) throws DataException {
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
