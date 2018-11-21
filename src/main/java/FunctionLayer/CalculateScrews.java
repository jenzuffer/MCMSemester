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

    public static void calculateScrewsclass(int length, int width, List<Materiale> list, boolean tag) throws LoginSampleException {
        int iLength = length;
        int amount = 0;
        List<Materiale> roofMaterialsForScrews = new ArrayList();
        CalculateRoof.CalculateRoofPlates(length, width, roofMaterialsForScrews, tag);
        for (int i = 0; i < roofMaterialsForScrews.size(); i++) {
            amount += roofMaterialsForScrews.get(i).getAmount();
        }
        List<Materiale> listofScrews = LogicFacade.listOfMaterialsByType("bundskruer");
        for (Materiale screwMaterials : listofScrews) {
            screwMaterials.addToAmount(amount / 2);
            list.add(screwMaterials);
        }
    }
}
