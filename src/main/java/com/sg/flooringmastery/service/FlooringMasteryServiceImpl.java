package com.sg.flooringmastery.service;
import com.sg.flooringmastery.dao.FlooringMasteryAuditDao;
import com.sg.flooringmastery.dao.FlooringMasteryDao;
import com.sg.flooringmastery.dao.exceptions.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.service.exceptions.FlooringMasteryContainsInvalidInputException;
import com.sg.flooringmastery.service.exceptions.FlooringMasteryNoOrdersForTheRequestedDateException;
import com.sg.flooringmastery.service.exceptions.FlooringMasteryOrderNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
/**
 * This class implements all the methods in FlooringMasteryService interface
 * @author Yi Yang
 *
 */
public class FlooringMasteryServiceImpl implements FlooringMasteryService{
    private final FlooringMasteryDao dao;
    private final FlooringMasteryAuditDao auditDao;
    
    /**
     * Constructs a new FlooringMasteryServiceImpl object
     * @param dao
     * @param auditDao 
     */
    public FlooringMasteryServiceImpl(FlooringMasteryDao dao, FlooringMasteryAuditDao auditDao) {
        this.dao = dao;  
        this.auditDao = auditDao;
    }
    /**
     * Returns the list of all orders in the program
     * @return Order list of all the orders
     * @throws FlooringMasteryPersistenceException 
     */
    @Override
    public List<Order> getAllOrders() throws FlooringMasteryPersistenceException {
        return dao.getAllOrders();
    }
    /**
     * Saves the changes
     * @throws FlooringMasteryPersistenceException 
     */
    @Override
    public void save() throws FlooringMasteryPersistenceException {
        dao.save();
    }
    /**
     * Adds an order to the order file
     * @param temp
     * @return the Order that was added
     * @throws FlooringMasteryPersistenceException
     * @throws FlooringMasteryContainsInvalidInputException 
     */
    @Override
    public Order addAnOrder(Order temp) throws FlooringMasteryPersistenceException, FlooringMasteryContainsInvalidInputException {
        return dao.addAnOrder(temp); 
    }
    /**
     * Edits existing information on an order
     * @param temp
     * @return the order that was edited
     * @throws FlooringMasteryPersistenceException
     * @throws FlooringMasteryOrderNotFoundException
     * @throws FlooringMasteryContainsInvalidInputException 
     */
    @Override 
    public Order editAnOrder(Order temp) throws FlooringMasteryPersistenceException, FlooringMasteryOrderNotFoundException, FlooringMasteryContainsInvalidInputException {
        return dao.editAnOrder(temp);
    }
    /**
     * Removes an order
     * @param temp
     * @return the Order object that was removed
     * @throws FlooringMasteryPersistenceException
     * @throws FlooringMasteryOrderNotFoundException 
     */
    @Override
    public Order removeAnOrder(int temp) throws FlooringMasteryPersistenceException, FlooringMasteryOrderNotFoundException {
        Order tempOrder = dao.getAnOrder(temp);
        return dao.removeAnOrder(tempOrder);  
    }
    /**
     * Validates the order with the date and order number
     * @param tempOrderNumber
     * @param tempDate
     * @return the Order that was validated
     * @throws FlooringMasteryPersistenceException
     * @throws FlooringMasteryOrderNotFoundException 
     */
    @Override
    public Order validateOrderByDateAndOrderNumber(int tempOrderNumber, String tempDate) throws FlooringMasteryPersistenceException, FlooringMasteryOrderNotFoundException{
        Order tempOrder = dao.getAnOrder(tempOrderNumber);
        if(tempOrder == null || !tempOrder.getDate().equals(tempDate)){
            throw new FlooringMasteryOrderNotFoundException("The order details provided do not correspond with an existing order");
        }
        return tempOrder;
    }
    /**
     * Returns the list of orders by the date
     * @param temp
     * @return Order list in that date
     * @throws FlooringMasteryPersistenceException
     * @throws FlooringMasteryNoOrdersForTheRequestedDateException 
     */
    @Override
    public List<Order> getOrderByDate(String temp) throws FlooringMasteryPersistenceException, FlooringMasteryNoOrdersForTheRequestedDateException{
        List<Order> orderByDate = dao.getAllOrders()
                .stream()
                .filter(s -> s.getDate().equals(temp))
                .collect(Collectors.toList());
        if(orderByDate.isEmpty()){
            throw new FlooringMasteryNoOrdersForTheRequestedDateException("This date has no orders associated with it.");
        }
        return orderByDate;
       
    }
    /**
     * Returns the list of orders with matching date and number
     * @param tempDate
     * @param tempOrderNumber
     * @return Order list that matches the date and number
     * @throws FlooringMasteryPersistenceException
     * @throws FlooringMasteryNoOrdersForTheRequestedDateException 
     */
    @Override
    public List<Order> getOrderByDateAndNumber(String tempDate, int tempOrderNumber) throws FlooringMasteryPersistenceException, FlooringMasteryNoOrdersForTheRequestedDateException{
        List<Order> orderByNumber = getOrderByDate(tempDate)
                .stream()
                .filter(s -> s.getOrderNumber() == (tempOrderNumber))
                .collect(Collectors.toList());
        if(orderByNumber.isEmpty()){
            throw new FlooringMasteryNoOrdersForTheRequestedDateException("This date has no orders associated with it.");
        }
        return orderByNumber;   
    }
    /**
     * Verifies if the tax and product is correct
     * @param temp
     * @return the Order that was verified
     * @throws FlooringMasteryPersistenceException
     * @throws FlooringMasteryContainsInvalidInputException 
     */
    @Override
    public Order verifyTaxAndProduct(Order temp)throws FlooringMasteryPersistenceException,FlooringMasteryContainsInvalidInputException {
       temp =  dao.verifyTaxAndProduct(temp);
       if(temp == null){
           throw new FlooringMasteryContainsInvalidInputException(" The order contains either incorrect Tax information or incorrect Product information");
        }
        return temp;
    }
    /**
     * Returns an order
     * @param temp
     * @return Order object to be returned
     * @throws FlooringMasteryPersistenceException 
     */
    @Override
    public Order getAnOrder(int temp) throws FlooringMasteryPersistenceException {
        return dao.getAnOrder(temp);
    }
    /**
     * Returns the list of orders filtered by choice
     * @param b
     * @param x
     * @return Order list filtered
     * @throws FlooringMasteryPersistenceException
     * @throws NumberFormatException 
     */
    @Override
    public List<Order> filterByChoice(int b, String x) throws FlooringMasteryPersistenceException, NumberFormatException 
    {
        List<Order> orderByMisc = dao.getAllOrders();
            switch(b) {
                case 1:
                    orderByMisc = orderByMisc
                        .stream()
                        .filter(s -> s.getState().equals(x))
                        .collect(Collectors.toList()); 
                    break;
                case 2:
                    orderByMisc = orderByMisc
                        .stream()
                        .filter(s -> s.getArea().compareTo(new BigDecimal(x)) == 0)
                        .collect(Collectors.toList()); 
                    break;
                case 3:
                    orderByMisc = orderByMisc
                        .stream()
                        .filter(s -> s.getOrderNumber() == Integer.parseInt(x))
                        .collect(Collectors.toList()); 
                    break;
                case 4:
                    orderByMisc = orderByMisc
                        .stream()
                        .filter(s -> s.getCustomerName().equals(x))
                        .collect(Collectors.toList()); 
                    break;
                case 5:
                    orderByMisc = orderByMisc
                        .stream()
                        .filter(s -> s.getStateAbbreviation().equals(x))
                        .collect(Collectors.toList()); 
                    break;
                case 6:
                    orderByMisc = orderByMisc
                        .stream()
                        .filter(s -> s.getProductType().equals(x))
                        .collect(Collectors.toList()); 
                    break;
                case 7:
                    orderByMisc = orderByMisc
                        .stream()
                        .filter(s -> s.getTaxRate().compareTo(new BigDecimal(x)) == 0)
                        .collect(Collectors.toList()); 
                    break;
                case 8:
                    orderByMisc = orderByMisc
                        .stream()
                        .filter(s -> s.getCostPSF().compareTo(new BigDecimal(x)) == 0)
                        .collect(Collectors.toList()); 
                    break;
                case 9:
                    orderByMisc = orderByMisc
                        .stream()
                        .filter(s -> s.getLaborCostPSF().compareTo(new BigDecimal(x)) == 0)
                        .collect(Collectors.toList()); 
                    break;
                case 10:
                    orderByMisc = orderByMisc
                        .stream()
                        .filter(s -> s.getMaterialCost().compareTo(new BigDecimal(x)) == 0)
                        .collect(Collectors.toList()); 
                    break;
                case 11:
                    orderByMisc = orderByMisc
                        .stream()
                        .filter(s -> s.getLaborCost().compareTo(new BigDecimal(x)) == 0)
                        .collect(Collectors.toList()); 
                    break;
                case 12:
                    orderByMisc = orderByMisc
                        .stream()
                        .filter(s -> s.getTaxCharged().compareTo(new BigDecimal(x)) == 0)
                        .collect(Collectors.toList()); 
                    break;
                case 13:
                    orderByMisc = orderByMisc
                        .stream()
                        .filter(s -> s.getTotal().compareTo(new BigDecimal(x)) == 0)
                        .collect(Collectors.toList()); 
                    break;
                case 14:
                    orderByMisc = orderByMisc
                        .stream()
                        .filter(s -> s.getDate().equals(x))
                        .collect(Collectors.toList()); 
                    break;
                default:
                    System.out.println("An error has occured!");
            }
        return orderByMisc;
    }
}
