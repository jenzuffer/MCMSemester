/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class CalculateScrews {

    //public List<Materiale> calculateScrewsClass(int length, int width, boolean tag, List<Materiale> roof) throws LoginSampleException {
    List<Materiale> calculateScrewsClass(List<Materiale> materials, int length, int width, boolean tag, List<Materiale> listOfRoofMaterials) throws LoginSampleException {
        List<Materiale> returnlist = new ArrayList();
        
        List<Materiale> listofScrews = LogicFacade.listOfMaterialsByType("bundskruer");
        /*
        for (Materiale material : materials) {
            if ("bundskruer".equals(material.getType())) {
                listofScrews.add(material);
            }
        }
        */
        int amount = 0;
        List<Materiale> roofMaterialsForScrews;
        roofMaterialsForScrews = listOfRoofMaterials;
        for (int i = 0; i < roofMaterialsForScrews.size(); i++) {
            amount += roofMaterialsForScrews.get(i).getAmount();
        }
        for (Materiale screwMaterials : listofScrews) {
            screwMaterials.addToAmount(amount / 2);
            returnlist.add(screwMaterials);
        }
        return returnlist;
    }

    public List<Materiale> calculateStainlessSteel(List<Materiale> materials, int length, int width, boolean tag) throws LoginSampleException {
        List<Materiale> returnlist = new ArrayList();
        List<Materiale> listofStainlessSteal = LogicFacade.listOfMaterialsByType("hulbånd");
        
        /*
        for (Materiale material : materials) {
            if ("hulbånd".equals(material.getType())) {
                listofStainlessSteal.add(material);
            }
        }
        */
        
        if (tag) {
            for (Materiale screwMaterials : listofStainlessSteal) {
                screwMaterials.addToAmount(2);
                returnlist.add(screwMaterials);
            }
        }
        return returnlist;
    }

}
