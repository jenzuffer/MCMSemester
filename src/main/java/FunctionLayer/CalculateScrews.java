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
        int iWidth = width;
        int amount = 0;
        
        //CalculateRoof.CalculateRoofPlates();
        //tagplader har length af 600 og 360, for hver tagplade kræver vi en pakke  platsmo bundskruer
        List<Materiale> listofScrews = LogicFacade.listOfMaterialsByType("bundskruer");
        List<Materiale> ListOfRoofMaterial = LogicFacade.listOfMaterialsByType("tagplader");
        List<Materiale> roofMaterialsForScrews = new ArrayList();

        
        for (Materiale screwMaterials : listofScrews) {
            screwMaterials.addToAmount(amount);
            list.add(screwMaterials);
        }
    }
}
