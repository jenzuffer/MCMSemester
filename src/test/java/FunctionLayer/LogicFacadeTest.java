package FunctionLayer;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mark
 */
public class LogicFacadeTest {

    public LogicFacadeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of calculateCarportList1 method, of class LogicFacade.
     */
    @Test
    public void testCalculateCarportList1() throws Exception {
        Carport carport = new Carport(360, 390, 0, 0, false, false);
        int expResult = 6;
        // as of current iteration, a list of 6 lists is added to the carport
        // if no shed is added.
        Carport result = LogicFacade.calculateCarportList(carport);
        assertEquals(expResult, result.getListOfLists().size());
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testCalculateCarportList5() throws Exception {
        Carport carport = new Carport(780, 600, 480, 450, false, false);
        int aLength = 780;
        int count = 1;
        while (aLength > 70) {
            aLength = aLength - 300;
            count++;
        }
        count = count * 2;
        int expRes = count;
        Carport result = LogicFacade.calculateCarportList(carport);
        int actualRes = carport.getListOfLists().get("carportpoles").get(0).getAmount();
        // as of current iteration, a list of 6 lists is added to the carport
        // if no shed is added.
        assertEquals(expRes, actualRes);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calculateCarportList2 method, of class LogicFacade.
     */
    @Test
    public void testCalculateCarportList2() throws Exception {
        Carport carport = new Carport(480, 390, 0, 0, false, false);
        Carport result = LogicFacade.calculateCarportList(carport);

        // this test shows when given the boolean: false for shed, 
        // that it doesnt add anything related to shed

        List<Materiale> expRes = null;
        for (String str : carport.getListOfLists().keySet()) {
            if (str.contains("shed")) {
                expRes = carport.getListOfLists().get(str);
            }
        }
        
        assertNull(expRes);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testCalculateCarportList3() throws Exception {
        Carport carport = new Carport(780, 750, 0, 0, false, false);
        int expResult = 6;
        // as of current iteration, a list of 6 lists is added to the carport
        // if no shed is added.
        Carport result = LogicFacade.calculateCarportList(carport);
        assertEquals(expResult, result.getListOfLists().size());
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testCalculateCarportList4() throws Exception {
        Carport carport = new Carport(240, 240, 0, 0, false, false);
        int expResult = 6;
        // as of current iteration, a list of 6 lists is added to the carport
        // if no shed is added.
        Carport result = LogicFacade.calculateCarportList(carport);
        assertEquals(expResult, result.getListOfLists().size());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getWidth method, of class LogicFacade.
     */
    @Test
    public void testGetWidth() throws Exception {
        int expResult = 18; // expected number of options for the menu
        List<Integer> result = LogicFacade.getWidth();
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getLength method, of class LogicFacade.
     */
    @Test
    public void testGetLength() throws Exception {
        int expResult = 19;
        List<Integer> result = LogicFacade.getLength();
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.
    }

}
