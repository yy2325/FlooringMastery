package com.sg.flooringmastery;
import com.sg.flooringmastery.controller.FlooringMasteryController;
import com.sg.flooringmastery.dao.exceptions.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.service.exceptions.FlooringMasteryContainsInvalidInputException;
import com.sg.flooringmastery.service.exceptions.FlooringMasteryNoOrdersForTheRequestedDateException;
import com.sg.flooringmastery.service.exceptions.FlooringMasteryOrderNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * This class contains the main method that runs the application
 * @author Yi Yang
 *
 */
public class App {
    /**
     * Main method of the program
     * @param args
     * @throws FlooringMasteryPersistenceException
     * @throws FlooringMasteryContainsInvalidInputException
     * @throws FlooringMasteryOrderNotFoundException
     * @throws FlooringMasteryNoOrdersForTheRequestedDateException 
     */
     public static void main(String[] args) throws FlooringMasteryPersistenceException, FlooringMasteryContainsInvalidInputException, FlooringMasteryOrderNotFoundException, FlooringMasteryNoOrdersForTheRequestedDateException  { //throws FlooringMasteryPersistenceException
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Config configuration = new Config();
        FlooringMasteryController controller = ctx.getBean(configuration.getMode(), FlooringMasteryController.class);
        controller.run(configuration.getPassword(), configuration.getMode());
     }
    
}
