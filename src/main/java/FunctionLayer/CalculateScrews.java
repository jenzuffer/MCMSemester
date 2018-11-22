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

    public List<Materiale> calculateScrewsClass(int length, int width, boolean tag, List<Materiale> roof) throws LoginSampleException {
        List<Materiale> returnlist = new ArrayList();
        int amount = 0;
        List<Materiale> roofMaterialsForScrews;
        roofMaterialsForScrews = roof;
        for (int i = 0; i < roofMaterialsForScrews.size(); i++) {
            amount += roofMaterialsForScrews.get(i).getAmount();
        }
        List<Materiale> listofScrews = LogicFacade.listOfMaterialsByType("bundskruer");
        for (Materiale screwMaterials : listofScrews) {
            screwMaterials.addToAmount(amount / 2);
            returnlist.add(screwMaterials);
        }
        return returnlist;
    }

    public List<Materiale> calculateStainlessSteel(int length, int width, boolean tag) throws LoginSampleException {
        List<Materiale> returnlist = new ArrayList();
        if (tag) {
            List<Materiale> ListofStainlessSteal = LogicFacade.listOfMaterialsByType("hulbånd");
            for (Materiale screwMaterials : ListofStainlessSteal) {
                screwMaterials.addToAmount(2);
                returnlist.add(screwMaterials);
            }
        }
        return returnlist;
    }
}
