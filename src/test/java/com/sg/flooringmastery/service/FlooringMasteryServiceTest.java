package com.sg.flooringmastery.service;

import com.sg.flooringmastery.service.exceptions.FlooringMasteryContainsInvalidInputException;
import com.sg.flooringmastery.service.exceptions.FlooringMasteryOrderNotFoundException;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This is a junit test class to test the functions of the service layer
 * @author Yi Yang
 *
 */
public class FlooringMasteryServiceTest {
    private final FlooringMasteryService service;
    /**
     * Constructs a new FlooringMasteryServiceTest object
     */
    public FlooringMasteryServiceTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("serviceLayer", FlooringMasteryServiceImpl.class);   
    }
    /**
     * Tests if the order is validated
     * @throws Exception 
     */
    @Test
    public void testValidateOrderForRemovalOrEditing() throws Exception {
        try {
            service.validateOrderByDateAndOrderNumber(3,"2018-3-20");
        fail("Expected FlooringMasteryOrderNotFoundException was not thrown.");
        } catch (FlooringMasteryOrderNotFoundException e) {
        }
    }
    /**
     * Tests if the tax and products has been verified
     * @throws Exception 
     */
    @Test
    public void testVerifyTaxAndProduct() throws Exception{
        try {
            service.verifyTaxAndProduct(service.getAnOrder(2));
        fail("Expected FlooringMasteryContainsInvalidInputException was not thrown.");
        } catch (FlooringMasteryContainsInvalidInputException e) {
        } 
    }
}
