package com.sg.flooringmastery.dao;
import com.sg.flooringmastery.dao.exceptions.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import java.util.ArrayList;
import java.util.List;
/**
 * This interface provides all methods needed to be implemented in FlooringMasteryDaoImpl
 * @author Yi Yang
 *
 */
public interface FlooringMasteryDao {
    /**
     * Returns list of all orders in the ordering program
     * @return Order list containing all the orders
     * @throws FlooringMasteryPersistenceException 
     */
    public List<Order> getAllOrders()throws FlooringMasteryPersistenceException;
    /**
     * Returns list of all products in the program
     * @return Product ArrayList object with all the products
     * @throws FlooringMasteryPersistenceException 
     */
    public ArrayList<Product> getAllProducts() throws FlooringMasteryPersistenceException;
    /**
     * Returns list of all the taxes
     * @return Tax ArrayList object with all the tax information
     * @throws FlooringMasteryPersistenceException 
     */
    public ArrayList<Tax> getAllTaxes() throws FlooringMasteryPersistenceException;
    /**
     * Writes the orders to the order file.
     * @throws FlooringMasteryPersistenceException 
     */
    public void writeOrdersToFile() throws FlooringMasteryPersistenceException;
    /**
     * Removes an order
     * @param temp
     * @return the Order object that was removed
     * @throws FlooringMasteryPersistenceException 
     */
    public Order removeAnOrder(Order temp)  throws FlooringMasteryPersistenceException;
    /**
     * Edits existing information on an order
     * @param tempOrder
     * @return the order that was edited
     * @throws FlooringMasteryPersistenceException 
     */
    public Order editAnOrder(Order tempOrder)  throws FlooringMasteryPersistenceException;
    /**
     * Adds an order to the order file
     * @param tempOrder
     * @return the Order that was added
     * @throws FlooringMasteryPersistenceException 
     */
    public Order addAnOrder(Order tempOrder)  throws FlooringMasteryPersistenceException;
    /**
     * Returns an order
     * @param temp
     * @return Order object to be returned
     * @throws FlooringMasteryPersistenceException 
     */
    public Order getAnOrder(int temp) throws FlooringMasteryPersistenceException;
    /**
     * Verifies if the tax and product is correct
     * @param temp
     * @return the Order that was verified
     * @throws FlooringMasteryPersistenceException 
     */
    public Order verifyTaxAndProduct(Order temp)throws FlooringMasteryPersistenceException;
    /**
     * Saves the changes
     * @throws FlooringMasteryPersistenceException 
     */
    public void save() throws FlooringMasteryPersistenceException;
     
}
