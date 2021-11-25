package com.sg.flooringmastery.service;
import com.sg.flooringmastery.dao.exceptions.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.service.exceptions.FlooringMasteryContainsInvalidInputException;
import com.sg.flooringmastery.service.exceptions.FlooringMasteryNoOrdersForTheRequestedDateException;
import com.sg.flooringmastery.service.exceptions.FlooringMasteryOrderNotFoundException;
import java.util.List;
/**
 * This interface contains all the methods to be implemented in
 * FlooringMasteryServiceImpl class.
 * @author Yi Yang
 *
 */
public interface FlooringMasteryService {
    /**
     * Returns the list of all orders in the program
     * @return Order list of all the orders
     * @throws FlooringMasteryPersistenceException 
     */
    public List<Order> getAllOrders() throws FlooringMasteryPersistenceException;
    /**
     * Saves the changes
     * @throws FlooringMasteryPersistenceException 
     */
    public void save()throws FlooringMasteryPersistenceException;
    /**
     * Adds an order to the order file
     * @param temp
     * @return the Order that was added
     * @throws FlooringMasteryPersistenceException
     * @throws FlooringMasteryContainsInvalidInputException 
     */
    public Order addAnOrder(Order temp) throws FlooringMasteryPersistenceException, FlooringMasteryContainsInvalidInputException;
    /**
     * Returns an order
     * @param temp
     * @return Order object to be returned
     * @throws FlooringMasteryPersistenceException 
     */
    public Order getAnOrder(int temp) throws FlooringMasteryPersistenceException;
    /**
     * Edits existing information on an order
     * @param order
     * @return the order that was edited
     * @throws FlooringMasteryPersistenceException
     * @throws FlooringMasteryOrderNotFoundException
     * @throws FlooringMasteryContainsInvalidInputException 
     */
    public Order editAnOrder(Order order)throws FlooringMasteryPersistenceException, FlooringMasteryOrderNotFoundException, FlooringMasteryContainsInvalidInputException;
    /**
     * Removes an order
     * @param temp
     * @return the Order object that was removed
     * @throws FlooringMasteryPersistenceException
     * @throws FlooringMasteryOrderNotFoundException 
     */
    public Order removeAnOrder(int temp)throws FlooringMasteryPersistenceException, FlooringMasteryOrderNotFoundException;
    /**
     * Returns the list of orders by the date
     * @param temp
     * @return Order list in that date
     * @throws FlooringMasteryPersistenceException
     * @throws FlooringMasteryNoOrdersForTheRequestedDateException 
     */
    public List<Order> getOrderByDate(String temp) throws FlooringMasteryPersistenceException, FlooringMasteryNoOrdersForTheRequestedDateException;
    /**
     * Verifies if the tax and product is correct
     * @param temp
     * @return the Order that was verified
     * @throws FlooringMasteryPersistenceException
     * @throws FlooringMasteryContainsInvalidInputException 
     */
    public Order verifyTaxAndProduct(Order temp)throws FlooringMasteryPersistenceException,FlooringMasteryContainsInvalidInputException ;
    /**
     * Validates the order with the date and order number
     * @param tempOrderNumber
     * @param tempDate
     * @return the Order that was validated
     * @throws FlooringMasteryPersistenceException
     * @throws FlooringMasteryOrderNotFoundException 
     */
    public Order validateOrderByDateAndOrderNumber(int tempOrderNumber, String tempDate)throws FlooringMasteryPersistenceException, FlooringMasteryOrderNotFoundException;
    /**
     * Returns the list of orders with matching date and number
     * @param tempDate
     * @param tempOrderNumber
     * @return Order list that matches the date and number
     * @throws FlooringMasteryPersistenceException
     * @throws FlooringMasteryNoOrdersForTheRequestedDateException 
     */
    public List<Order> getOrderByDateAndNumber(String tempDate, int tempOrderNumber) throws FlooringMasteryPersistenceException, FlooringMasteryNoOrdersForTheRequestedDateException;
    /**
     * Returns the list of orders filtered by choice
     * @param a
     * @param b
     * @return Order list filtered
     * @throws FlooringMasteryPersistenceException 
     */
    public List<Order> filterByChoice(int a, String b) throws FlooringMasteryPersistenceException; 
    
}