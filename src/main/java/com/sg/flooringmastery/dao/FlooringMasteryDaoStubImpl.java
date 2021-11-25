package com.sg.flooringmastery.dao;
import com.sg.flooringmastery.dao.exceptions.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * This is a stub implementation of FlooringMasteryDao interface
 * for testing purposes.
 * @author Yi Yang
 *
 */
public class FlooringMasteryDaoStubImpl implements FlooringMasteryDao {

    private final Map<Integer, Order> orders = new HashMap<>();
    private final Map<String, Tax> taxes = new HashMap<>();
    private final Map<String, Product> products = new HashMap<>();
    private final Order stubOrder;
    private final Order stubOrder2;
    private final Order stubOrder3;
    
    /**
     * Constructs a new FlooringMasteryDaoStubImpl object
     */
    public FlooringMasteryDaoStubImpl() {
        this.stubOrder = new Order(1, "2001-3-20");
        this.stubOrder.setState("NY");
        this.stubOrder.setProductType("Wood");
        orders.put(1,stubOrder);
        this.stubOrder2 = new Order (2, "2000-3-20");
        this.stubOrder2.setState("HI");
        this.stubOrder2.setProductType("Granite");
        orders.put(2,stubOrder2);
        this.stubOrder3 = new Order (3, "2018-3-20");
        taxes.put("NY", null);
        products.put("Wood",null);
    
    }
    /**
     * Returns list of all orders in the ordering program
     * @return Order list containing all the orders
     * @throws FlooringMasteryPersistenceException 
     */
    @Override
    public List<Order> getAllOrders() throws FlooringMasteryPersistenceException {
        return new ArrayList<>(orders.values());
    }
    /**
     * Returns list of all products in the program
     * @return Product ArrayList object with all the products
     * @throws FlooringMasteryPersistenceException 
     */
    @Override
    public ArrayList<Product> getAllProducts() throws FlooringMasteryPersistenceException {
        return new ArrayList<>(products.values());
    }
    /**
     * Returns list of all the taxes
     * @return Tax ArrayList object with all the tax information
     * @throws FlooringMasteryPersistenceException 
     */
    @Override
    public ArrayList<Tax> getAllTaxes() throws FlooringMasteryPersistenceException {
        return new ArrayList<>(taxes.values());
    }
    /**
     * Removes an order
     * @param removedOrder
     * @return the Order object that was removed
     * @throws FlooringMasteryPersistenceException 
     */
    @Override
    public Order removeAnOrder(Order removedOrder) throws FlooringMasteryPersistenceException {
        orders.remove(removedOrder.getOrderNumber());
        return removedOrder;
    }
    /**
     * Edits existing information on an order
     * @param tempOrder
     * @return the order that was edited
     * @throws FlooringMasteryPersistenceException 
     */
    @Override
    public Order editAnOrder(Order tempOrder) throws FlooringMasteryPersistenceException {
        orders.put(tempOrder.getOrderNumber(), tempOrder);
        return tempOrder;
    }
    /**
     * Adds an order to the order file
     * @param tempOrder
     * @return the Order that was added
     * @throws FlooringMasteryPersistenceException 
     */
    @Override
    public Order addAnOrder(Order tempOrder) throws FlooringMasteryPersistenceException {
        orders.put(tempOrder.getOrderNumber(),tempOrder);
        // writeOrdersToFile();
        return tempOrder;
    }
    /**
     * Returns an order
     * @param temp
     * @return Order object to be returned
     * @throws FlooringMasteryPersistenceException 
     */
    @Override
    public Order getAnOrder(int temp) throws FlooringMasteryPersistenceException {
        return orders.get(temp);
    }
    /**
     * Verifies if the tax and product is correct
     * @param temp
     * @return the Order that was verified
     * @throws FlooringMasteryPersistenceException 
     */
    @Override
    public Order verifyTaxAndProduct(Order temp) throws FlooringMasteryPersistenceException {
        if(taxes.keySet().contains(temp.getStateAbbreviation()) && products.keySet().contains(temp.getProductType())){
            Tax temporaryTax = taxes.get(temp.getStateAbbreviation());
            Product temporaryProduct = products.get(temp.getProductType());
            temp.setState(temporaryTax.getState());
            temp.setTaxRate(temporaryTax.getTaxRate());
            temp.setCostPSF(temporaryProduct.getCostPSF());
            temp.setLaborCostPSF(temporaryProduct.getLaborCostPSF());
        }else{
            temp = null;
        }
        System.out.println(temp);
        return temp;
    }
    /**
     * Writes the orders to the order file.
     * @throws FlooringMasteryPersistenceException 
     */
    @Override
    public void writeOrdersToFile() throws FlooringMasteryPersistenceException{
    }
    /**
     * Saves the changes
     * @throws FlooringMasteryPersistenceException 
     */
    @Override
    public void save() throws FlooringMasteryPersistenceException {
    }
    
}