/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Material;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Christian
 */
public class DataMapperTest {

    @Test
    public void getWidthTest() throws Exception {
        List<Integer> expectedWidths = DataMapper.getWidth();
        assertEquals((Object) 240, expectedWidths.get(0));
        assertEquals((Object) 600, expectedWidths.get(12));
    }

    @Test
    public void getLengthTest() throws Exception {
        List<Integer> expectedLength = DataMapper.getLength();
        assertEquals((Object) 270, expectedLength.get(1));
        assertEquals((Object) 780, expectedLength.get(18));
    }

    @Test
    public void getShedWidthTest() throws Exception {
        List<Integer> expectedshedWidth = DataMapper.getShedWidth();
        assertEquals((Object) 210, expectedshedWidth.get(0));
        assertEquals((Object) 390, expectedshedWidth.get(6));
    }

    @Test
    public void getShedLengthTest() throws Exception {
        List<Integer> expectedShedLength = DataMapper.getShedLength();
        assertEquals((Object) 150, expectedShedLength.get(0));
        assertEquals((Object) 180, expectedShedLength.get(1));
    }

    @Test
    public void getCustomerIDByPhoneNumberTest() throws Exception {
        String phonenumber = "21";
        int expectedCustomderID = 3;
        int customerID = DataMapper.getCustomerIDByPhoneNumber(phonenumber);
        assertEquals(expectedCustomderID, customerID);
    }

    @Test
    public void getCarportIDByCustomerIDTest() throws Exception {
        String phonenumber = "23456789";
        int customerID = DataMapper.getCustomerIDByPhoneNumber(phonenumber);
        int carport = DataMapper.getCarportIDByCustomerID(customerID);
        int expectedCarportID = 3;
        assertEquals(expectedCarportID, carport);
    }
    @Test
    public void getAllMaterialsByTypeTest() throws Exception {
        String type = "spærtræ";
        List<Material> AllMaterialsByType = DataMapper.getAllMaterialsByType(type);
        assertEquals(132, AllMaterialsByType.get(AllMaterialsByType.size() - 1).getPrice());
        assertEquals(660, AllMaterialsByType.get(1).getLength());
        type = "tagplader";
        List<Material> AllMaterialsByType1 = DataMapper.getAllMaterialsByType(type);
        assertEquals("Plastmo Ecolite blåtonet", AllMaterialsByType1.get(0).getName());
    }
    @Test
    public void getAllMaterialsTest() throws Exception {
        List<Material> AllMaterials = DataMapper.getAllMaterials();
        assertEquals(211, AllMaterials.get(3).getPrice());
        assertEquals("97x97 mm. trykimp. Stolpe", AllMaterials.get(8).getName());
        assertEquals("Til montering af spær på ræm", AllMaterials.get(12).getDescription());
    }
}
