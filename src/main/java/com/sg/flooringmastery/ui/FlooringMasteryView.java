package com.sg.flooringmastery.ui;
import com.sg.flooringmastery.dto.Months;
import com.sg.flooringmastery.dto.Order;
import java.util.List;
/**
 * This class will show all the messages to be printed to the user
 * when running the application
 * @author Yi Yang
 *
 */
public class FlooringMasteryView {
    UserIO io;
    Months month1;
    /**
     * Constructs a new FlooringMasteryView object
     * @param io 
     */
    public FlooringMasteryView(UserIO io) {
        this.io = io;
    }
    /**
     * The banner to be displayed to begin the application
     */
    public void sayHello() {
        io.print("\nWelcome to Yi's Floors Inc., We hope you enjoy your visit!\n");
    }
    /**
     * Displays all the orders
     * @param orderList 
     */
    public void displayOrderList(List<Order> orderList) {
        for (Order currentOrder : orderList) {
            io.print(currentOrder.toString());
        }
        io.readString("Please hit enter to continue.");
     }
    /**
     * Prints out the menu options to display
     * @return the option that is selected between 1 and 2
     */
    public int getMenuSelection() {
        io.print("\n What would you like to do?");
        return io.readInt("\n *        *        * \n1. Display Orders \n2. Add an Order \n3. Edit an Order \n4. Remove an Order \n5. Save Current Work \n6. Quit \n *        *        *", 0, 6);
    }
    /**
     * The banner to be displayed at the end of the application
     */
    public void sayGoodBye() {
        io.print("\n Thanks! Have a nice day! \n");
    }
    /**
     * Prints out string
     * @param message
     */
    public void displayString(String message) {
        io.print(message);
    }
    /**
     * Asks for order number
     * @return the order number
     */
    public int getOrderNumber() {
        return io.readInt("Which order number are you interested in?");
    }
    /**
     * Returns the order
     * @param nextOrderNumber
     * @return Order object of the order
     */
    public Order getOrder(int nextOrderNumber) {
        String orderDate = getOrderDate();
        Order tempOrder = new Order(nextOrderNumber, orderDate);
        tempOrder.setCustomerName(io.readString("What is the customer's name?"));
        tempOrder.setStateAbbreviation(io.readString("What is the State Abbreviation?"));
        tempOrder.setArea(io.readBigDecimal("What is the area?"));
        tempOrder.setProductType(io.readString("What is the product type?"));
        return tempOrder;
    }
    /**
     * Returns the date of the order
     * @return order date
     */
    public String getOrderDate(){
        int temp = io.readInt("\n Which year are you interested in? \n",0,3141);
        for(Months month: Months.values()){
            io.print(month + " (" + month.getMonthInNumber() +  ") : 1 to " + month.getMaxNumberOfDays());
        }
        int temp1 = io.readInt("\n Please enter the month that you are interested in (number)? \n",1,12);
        month1 = Months.values()[temp1 - 1];
        int temp2 = io.readInt("\n Please enter the day of the month. \n",1,month1.getMaxNumberOfDays());
        return temp + "-" + temp1 + "-" + temp2;
    }
    /**
     * Prints out error message
     * @param message 
     */
    public void printErrorMessage(String message) {
        io.print("\n=== ERROR ===\n" + message + "\n=== ERROR ===\n");  
    }
    /**
     * Displays the order, and as for if user wants to proceed
     * @param temp
     * @return user choice
     */
    public int displayOrderAndGetCommitment(Order temp) {
        int whatToDo = io.readInt(temp.toString() + "\n \n If you would like to proceed with these changes press 1, press 2 to abandon current changes",1,2);
        return whatToDo;
    }
    /**
     * Asks to end the program
     * @param message
     * @return choice between 1 and 2
     */
    public int endProgram(String message) {
        return io.readInt(message,1,2);
    }
    /**
     * Returns the order to be edited
     * @param tempOrder
     * @return Order to be edited
     */
    public Order getOrderForEditing(Order tempOrder) {
        tempOrder.setCustomerName(io.readString("What is the customer's name (" + tempOrder.getCustomerName() + ")?"  ,tempOrder.getCustomerName(),""));
        tempOrder.setStateAbbreviation(io.readString("What is the State Abbreviation (" + tempOrder.getStateAbbreviation() + ")?"  ,tempOrder.getStateAbbreviation(),""));
        tempOrder.setArea(io.readBigDecimal("What is the area ("  + tempOrder.getArea() + ")?",tempOrder.getArea()));
        tempOrder.setProductType(io.readString("What is the product type ("  + tempOrder.getProductType() + ")?"  ,tempOrder.getProductType(),""));
        tempOrder.calculateOtherValues();
        return tempOrder;
    }

    /**
     * Asks how user would like to sort
     * @return user choice
     */
    public int getSortingCriteria(){
        io.print("Your choices for sorting are : \n 1. State \n 2. Area \n 3. Order Number \n 4.Customer Name \n 5. State Abbreviation  \n 6. Product Type"
        + "\n 7. Tax Rate \n 8. Cost Per Square Foot \n 9. Labor Cost Per Square Foot \n 10. Material Cost \n 11. Labor Cost \n 12. Tax Charged \n 13. Total \n 14. Date");
        int b = io.readInt("Which category would you like to sort by?",1,14);
        return b;
    }   
    /**
     * Asks user what they would like to sort by
     * @param b
     * @return user choice
     */
    public String getSortingVariable(int b){
        String alpha = io.readString("Please input the sorting parameter (i.e. a name, a date (YYYY-M-D), a price or an order number)?");
        return alpha;
    }

}
