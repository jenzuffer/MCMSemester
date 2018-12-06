/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.User;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Christian
 */
public class UsermapperTest {

    @Test
    public void testUsermapperLogin() throws Exception {
        User user = new User("ah", "street 8", "York", "83", "someemail@nowhere.com");
        User expectedUser = UserMapper.login(user.getEmail(), "4353453453");
        assertEquals("admin", expectedUser.getRole());
        assertEquals(3, expectedUser.getId());
    }

    @Test
    public void testgetLoginRole() throws Exception {
        String email = "cph-mn492@cphbusiness.dk";
        String password = "11111111";
        String expectedUserRole = UserMapper.getLoginRole(email, password);
        assertEquals("customer", expectedUserRole);
    }
   
}
