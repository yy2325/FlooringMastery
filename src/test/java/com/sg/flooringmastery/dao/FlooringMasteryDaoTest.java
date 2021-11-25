package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import static org.junit.Assert.*;

/**
 * This is a junit testing class for FlooringMasteryDao
 * @author Yi Yang
 *
 */
public class FlooringMasteryDaoTest {
    
    FlooringMasteryDao dao = new FlooringMasteryDaoStubImpl();
    /**
     * Constructs a new FlooringMasteryDaoTest object
     */
    public FlooringMasteryDaoTest() {
    }
    /**
     * Test of getAllSOrders method, of class FlooringMasteryDao.
     */
    @org.junit.Test
    public void testGetAllOrders() throws Exception {
        dao.getAllOrders();
        assertEquals(2, dao.getAllOrders().size());
    }
    /**
     * Test of removeAnOrder method, of class FlooringMasteryDao.
     */
    @org.junit.Test
    public void testRemoveAnOrder() throws Exception {
        Order temp = dao.getAnOrder(2);
        dao.removeAnOrder(temp);
        assertEquals(1, dao.getAllOrders().size()); // keep in mind that my hashmap.size = 1
    }
    /**
     * Test of addAnOrder method, of class FlooringMasteryDao.
     */
    @org.junit.Test
    public void testAddAnOrder() throws Exception{
        Order temp = new Order(2,"2012-12-12");
        dao.addAnOrder(temp);
        assertEquals(2, dao.getAllOrders().size()); // keep in mind taht my hashmap.size should equal 2
    }
    
}
