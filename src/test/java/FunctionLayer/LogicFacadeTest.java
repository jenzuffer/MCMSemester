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

    /**
     * Test of calculateCarportList2 method, of class LogicFacade.
     */
    @Test
    public void testCalculateCarportList2() throws Exception {
        Carport carport = new Carport(360, 390, 0, 0, true, true);
        int expResult = 9;
        // as of current interation, a list of 9 lists is added to the carport
        // if a shed is added (first boolean parameter is set true)
        Carport result = LogicFacade.calculateCarportList(carport);
        assertEquals(expResult, result.getListOfLists().size());
        // TODO review the generated test code and remove the default call to fail.
    }
    
    
    @Test
    public void testChangeOrder() throws Exception {
        Carport carport = new Carport(360, 390, 0, 0, true, true);
        
    
    
    
    }

}
