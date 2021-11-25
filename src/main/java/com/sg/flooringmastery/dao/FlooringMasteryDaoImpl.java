package com.sg.flooringmastery.dao;
import com.sg.flooringmastery.dao.exceptions.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.dto.Product;
import com.sg.flooringmastery.dto.Tax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 * This class implements all the methods in FlooringMasteryDao interface
 * @author Yi Yang
 *
 */
public class FlooringMasteryDaoImpl implements FlooringMasteryDao{
    public static final String ORDER_FILE = "orders.txt";
    public static final String TAX_FILE = "tax.txt";
    public static final String PRODUCT_FILE = "product.txt";
    public static final String DELIMITER = "::";
    protected Map<Integer, Order> orders = new HashMap<>();
    private final Map<String, Tax> taxes = new HashMap<>();
    private final Map<String, Product> products = new HashMap<>();
    /**
     * Constructs a new FlooringMasteryDaoImpl object
     * @throws FlooringMasteryPersistenceException 
     */
    public FlooringMasteryDaoImpl() throws FlooringMasteryPersistenceException {
        loadAllOrders();
        loadAllProducts();
        loadAllTaxes();
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
        //writeOrdersToFile();
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
        loadAllOrders();
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
        Order temporary = orders.get(temp);
        return temporary;
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
        return temp;
    }
    /**
     * Loads all the orders
     * @throws FlooringMasteryPersistenceException 
     */
    private void loadAllOrders() throws FlooringMasteryPersistenceException {
        Scanner scanner;
        try {
            // Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(ORDER_FILE))); 
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException("Could not load the orders into memory", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentTokens will hold the different elements of the items
        String[] currentTokens;
        // creates the hashmap with all
        while(scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(DELIMITER);
            // sets the elements
            Order currentOrder = new Order(Integer.parseInt(currentTokens[0]),currentTokens[13]);
            currentOrder.setCustomerName((currentTokens[1]));
            currentOrder.setStateAbbreviation((currentTokens[2]));
            currentOrder.setState((currentTokens[3]));
            currentOrder.setTaxRate((new BigDecimal(currentTokens[4])));
            currentOrder.setProductType((currentTokens[5]));
            currentOrder.setArea(new BigDecimal(currentTokens[6]));
            currentOrder.setCostPSF(new BigDecimal((currentTokens[7]) ));
            currentOrder.setLaborCostPSF(new BigDecimal((currentTokens[8])));
            currentOrder.setMaterialCost((new BigDecimal(currentTokens[9])));
            currentOrder.setLaborCost(new BigDecimal(currentTokens[10]));
            currentOrder.setTaxCharged(new BigDecimal((currentTokens[11]) ));
            currentOrder.setTotal(new BigDecimal((currentTokens[12])));
            orders.put(currentOrder.getOrderNumber(), currentOrder);
        }
        scanner.close();
    }
    /**
     * Loads all the products
     * @throws FlooringMasteryPersistenceException 
     */
    private void loadAllProducts() throws FlooringMasteryPersistenceException {
        Scanner scanner;
        try {
            // Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(PRODUCT_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException("Could not load the products into memory", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentTokens will hold the different elements of the items
        String[] currentTokens;
        // creates the hashmap with all
        while(scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(DELIMITER);
            // sets the elements
            Product currentProduct = new Product(currentTokens[0],(currentTokens[1]),(currentTokens[2]));
            products.put(currentProduct.getProductType(), currentProduct);
        }
        scanner.close();
    }
    /**
     * Loads all the taxes
     * @throws FlooringMasteryPersistenceException 
     */
    private void loadAllTaxes() throws FlooringMasteryPersistenceException {
        Scanner scanner;
        try {
            // Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(TAX_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException("Could not load the taxes into memory", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentTokens will hold the different elements of the items
        String[] currentTokens;
        while(scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(DELIMITER);
            // sets the elements
            Tax currentTax = new Tax(currentTokens[1],currentTokens[0],new BigDecimal(currentTokens[2]));
            taxes.put(currentTax.getStateAbbreviation(), currentTax);
        }
        
        scanner.close();
    }
    /**
     * Writes the orders to the order file.
     * @throws FlooringMasteryPersistenceException 
     */
    @Override
    public void writeOrdersToFile() throws FlooringMasteryPersistenceException{
        PrintWriter out;
        try {
            // Create PrintWriter for writing the file
            out = new PrintWriter(new FileWriter(ORDER_FILE));
        } catch(IOException e) {
                throw new FlooringMasteryPersistenceException("Could not save order data.", e);
        }
        // Write out vending info to the inventory file
        List<Order> allOrders =  this.getAllOrders();
        // iterate through the list and get all the elements
        for(Order order: allOrders) {
            out.println(
            order.getOrderNumber() + DELIMITER + 
            order.getCustomerName() + DELIMITER + 
            order.getStateAbbreviation() + DELIMITER + 
            order.getState() + DELIMITER + 
            order.getTaxRate() + DELIMITER + 
            order.getProductType() + DELIMITER + 
            order.getArea() + DELIMITER + 
            order.getCostPSF() + DELIMITER + 
            order.getLaborCostPSF() + DELIMITER + 
            order.getMaterialCost() + DELIMITER + 
            order.getLaborCost() + DELIMITER + 
            order.getTaxCharged() + DELIMITER + 
            order.getTotal() + DELIMITER +
            order.getDate());
            out.flush();
        }
        out.close();
    }
    /**
     * Saves the changes
     * @throws FlooringMasteryPersistenceException 
     */
    @Override
    public void save() throws FlooringMasteryPersistenceException {
        writeOrdersToFile();
        
    }
    
    

}
