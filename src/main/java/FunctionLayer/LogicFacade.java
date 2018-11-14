/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import DBAccess.DataMapper;
import PresentationLayer.Materials;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Christian
 */
public class LogicFacade {

    public static List<CarportDimensioner> getMaterials() {
        List<CarportDimensioner> TotalMaterials = new ArrayList();

        return TotalMaterials;
    }

    public static CarportDimensioner changeOrder(int OrderID, CarportDimensioner dimension) throws LoginSampleException {
        dimension = DataMapper.changeOrder(dimension, OrderID);
        throw new LoginSampleException("materials length: " + dimension.getLength());
    }

    public static List<Materials> calculateOrder(CarportDimensioner dimension, int indexID) throws LoginSampleException {
        List<Materials> materials = DataMapper.calculateOrder(dimension, indexID);

        return materials;
    }

    public static CarportDimensioner createCarport(int length, int width) {
        CarportDimensioner createCarport = new CarportDimensioner(length, width);
        return createCarport;
    }

 

    public static List<Integer> getWdith() throws LoginSampleException {
        List<Integer> width = DataMapper.getWidth();
        return width;
    }

    public static List<Integer> getLength() throws LoginSampleException {
        List<Integer> length = DataMapper.getLength();
        return length;
    }
}
