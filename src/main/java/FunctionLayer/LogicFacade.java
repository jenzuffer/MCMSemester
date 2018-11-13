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

    public static List<CarportDimensioner> GetMaterials() {
        List<CarportDimensioner> TotalMaterials = new ArrayList();

        return TotalMaterials;
    }

    public static CarportDimensioner ChangeOrder(int OrderID, CarportDimensioner dimension) throws LoginSampleException {
        dimension = DataMapper.ChangeOrder(dimension, OrderID);
        throw new LoginSampleException("materials length: " + dimension.getLength());
    }

    public static List<Materials> CalculateOrder(CarportDimensioner dimension, int indexID) throws LoginSampleException {
        List<Materials> materials = DataMapper.CalculateOrder(dimension, indexID);

        return materials;
    }

    public static CarportDimensioner CreateCarport(int height, int width, int length, int polls, int spears) {
        CarportDimensioner CreateCarport = new CarportDimensioner(height, width, length, polls, spears);
        return CreateCarport;
    }

    public static Map<Integer, Integer> GetWidthAndLength() throws LoginSampleException {
        Map<Integer, Integer> HM = DataMapper.GetWidthAndLength();
        return HM;
    }
}
