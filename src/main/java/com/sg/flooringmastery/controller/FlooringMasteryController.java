package com.sg.flooringmastery.controller;
import com.sg.flooringmastery.dao.exceptions.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.service.FlooringMasteryService;
import com.sg.flooringmastery.service.exceptions.FlooringMasteryContainsInvalidInputException;
import com.sg.flooringmastery.service.exceptions.FlooringMasteryNoOrdersForTheRequestedDateException;
import com.sg.flooringmastery.service.exceptions.FlooringMasteryOrderNotFoundException;
import com.sg.flooringmastery.ui.FlooringMasteryView;
/**
 * This class is the controller, it controls the menu, as well as
 * implementing different methods for different options.
 * This program allows 6 different features for users to interact with the ordering program
 * @author Yi Yang
 *
 */
public class FlooringMasteryController {
    private final FlooringMasteryService service;
    private final FlooringMasteryView view;
    /**
     * Constructs a new FlooringMasteryController object
     * @param service FlooringMasteryService object
     * @param view FlooringMasteryView object
     */    
    public FlooringMasteryController(FlooringMasteryService service, FlooringMasteryView view) {
        this.service = service;
        this.view = view;
    }
    /**
     * Creates a loop that will execute different features
     * when a menu option is selected
     * @param password Password being passed from configurations
     * @param mode Mode being passed from configurations
     * @throws FlooringMasteryPersistenceException
     * @throws FlooringMasteryContainsInvalidInputException
     * @throws FlooringMasteryOrderNotFoundException
     * @throws FlooringMasteryNoOrdersForTheRequestedDateException 
     */
    public void run(String password, String mode) throws FlooringMasteryPersistenceException, FlooringMasteryContainsInvalidInputException, FlooringMasteryOrderNotFoundException, FlooringMasteryNoOrdersForTheRequestedDateException {
        view.sayHello();
        boolean keepGoing = true;
        do {
            if(mode.equals("trainingController")){
                view.displayString("\n You are currently in training mode. Saving in training mode will not persist data.");
            } 
            int userChoice =  view.getMenuSelection();
                
            switch(userChoice) {
                case 0:
                    //keepGoing = runAdminControls();
                    displayOrderByInput();
                    break;
                case 1:
                    displayOrders(); // displayOrder method in your view.displayOrdersList < - controller... service -> dao .
                    break;
                case 2:
                    addAnOrder();   
                    break;
                case 3:
                    editAnOrder();
                    break;
                case 4:
                    removeAnOrder();
                    break;
                case 5:
                    save();
                    break;
                case 6:
                    keepGoing = endProgram();
                    break;
                default:
                    System.out.println("An error has occured!");
            }

        } while(keepGoing);
    
    }
    /**
     * Displays all the orders currently stored
     * @throws FlooringMasteryPersistenceException
     * @throws FlooringMasteryNoOrdersForTheRequestedDateException 
     */
    //     VIEW <- CONTROLLER -> SERVICE    ->   DAO
    private void displayOrders() throws FlooringMasteryPersistenceException, FlooringMasteryNoOrdersForTheRequestedDateException {
        String temp = view.getOrderDate();
        try{
            view.displayOrderList(service.getOrderByDate(temp));
        }catch(FlooringMasteryNoOrdersForTheRequestedDateException e){
            view.printErrorMessage(e.getMessage());
        }
        
    } 
    /**
     * Adds an order to the order list
     * @throws FlooringMasteryPersistenceException
     * @throws FlooringMasteryContainsInvalidInputException 
     */
    private void addAnOrder() throws FlooringMasteryPersistenceException, FlooringMasteryContainsInvalidInputException{
        Order temp = getOrder();
        try{
            temp = service.verifyTaxAndProduct(temp);
            temp.calculateOtherValues();
            int keepOrThrowOut = view.displayOrderAndGetCommitment(temp);
            
            if(keepOrThrowOut == 1){
                service.addAnOrder(temp);
            }else{
                view.displayString("Your order will be discarded;");
            }
        }catch(FlooringMasteryContainsInvalidInputException e){
            view.printErrorMessage(e.getMessage());
        }
        
    }
    /**
     * Edits an existing order
     * @throws FlooringMasteryPersistenceException
     * @throws FlooringMasteryOrderNotFoundException
     * @throws FlooringMasteryContainsInvalidInputException
     * @throws FlooringMasteryNoOrdersForTheRequestedDateException 
     */
    private void editAnOrder() throws FlooringMasteryPersistenceException, FlooringMasteryOrderNotFoundException, FlooringMasteryContainsInvalidInputException, FlooringMasteryNoOrdersForTheRequestedDateException{
        String tempDate = view.getOrderDate();
        int tempOrderNumber = view.getOrderNumber();
        try{
            Order placeHolder = service.validateOrderByDateAndOrderNumber(tempOrderNumber, tempDate);
            view.displayOrderList(service.getOrderByDateAndNumber(tempDate, tempOrderNumber));
            
            Order tempOrder = view.getOrderForEditing(placeHolder);
            
            int keepOrThrowOut = view.displayOrderAndGetCommitment(tempOrder);
            
            if(keepOrThrowOut == 1){
                service.verifyTaxAndProduct(tempOrder);
                service.editAnOrder(tempOrder);
            }else{
                view.displayString("Your order will be discarded;");
            }
            
        }catch(FlooringMasteryOrderNotFoundException | FlooringMasteryContainsInvalidInputException e){
            view.printErrorMessage(e.getMessage());
        }
       
    }
    /**
     * Removes an existing order
     * @throws FlooringMasteryPersistenceException
     * @throws FlooringMasteryOrderNotFoundException 
     */
    private void removeAnOrder() throws FlooringMasteryPersistenceException, FlooringMasteryOrderNotFoundException{
        String tempDate = view.getOrderDate();
        int tempOrderNumber = view.getOrderNumber();
        
        try{
            int keepOrNot = view.displayOrderAndGetCommitment(service.validateOrderByDateAndOrderNumber(tempOrderNumber,tempDate));
            if (keepOrNot == 1 ){
                service.removeAnOrder(tempOrderNumber);
            } else {
                view.displayString("The current order will not be deleted.");
            }
             
        }catch(FlooringMasteryOrderNotFoundException e){
            view.printErrorMessage(e.getMessage());
        }
        
    }
    /**
     * Saves all the changes
     * @throws FlooringMasteryPersistenceException 
     */
    private void save() throws FlooringMasteryPersistenceException {
        
        try{
            service.save();
            view.displayString("You're data has been persisted to the file!");
        }catch(FlooringMasteryPersistenceException e){
            view.printErrorMessage(e.getMessage());
        }
        
    }
    /**
     * Gets the order info
     * @return Order object of the order
     * @throws FlooringMasteryPersistenceException 
     */
    private Order getOrder() throws FlooringMasteryPersistenceException {
        int a = service.getAllOrders().size() + 1;
        return view.getOrder(a);
    }
    /**
     * Ends the program
     * @return whether true to end, or false to continue
     * @throws FlooringMasteryPersistenceException 
     */
    private Boolean endProgram() throws FlooringMasteryPersistenceException {
        int temp  = view.endProgram("Are you sure you wish to exit? \nEnter 1 to exit, 2 to continue."); 
        Boolean toEndOrNot = false;
        if(temp == 1){
            service.save();
            view.sayGoodBye();
        }else{
            toEndOrNot = true;
        }
        return toEndOrNot;    
    }
    /**
     * Displays all the order by the input
     * @throws FlooringMasteryPersistenceException 
     */
    private void displayOrderByInput() throws FlooringMasteryPersistenceException {
        int temp = view.getSortingCriteria();
        String x = view.getSortingVariable(temp);
        try{
            view.displayOrderList(service.filterByChoice(temp,x));
        }catch(NumberFormatException e){
            view.displayString("\nYour inputs did not match");
        }
    }

}