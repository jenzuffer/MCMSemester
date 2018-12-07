/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import PresentationLayer.Order;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Christian
 */
public class OrderMapperTest {
    @Test
    public void TestgetOrderList() throws Exception {
        List<Order> OrderList = OrderMapper.getOrderList();
        assertEquals("street 8", OrderList.get(0).getAdress());
        assertEquals(2, OrderList.get(0).getCarportID());
        assertEquals(720, OrderList.get(0).getLength());
    }
}