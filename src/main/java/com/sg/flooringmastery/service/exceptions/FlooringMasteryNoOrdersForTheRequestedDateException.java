package com.sg.flooringmastery.service.exceptions;

/**
 * This class defines the FlooringMasteryNoOrdersForTheRequestedDateException
 * and the error message
 * @author Yi Yang
 *
 */
public class FlooringMasteryNoOrdersForTheRequestedDateException extends Exception {
    /**
     * Constructs a new FlooringMasteryNoOrdersForTheRequestedDateException object given message
     * @param message 
     */
    public FlooringMasteryNoOrdersForTheRequestedDateException(String message) {
        super(message);
    }
    /**
     * Constructs a new FlooringMasteryNoOrdersForTheRequestedDateException object
     * given message and cause
     * @param message
     * @param cause 
     */
    public FlooringMasteryNoOrdersForTheRequestedDateException(String message,
            Throwable cause) {
        super(message, cause);
    }
    /**
     * Prints out the error message
     * @return error message
     */
    @Override
    public String toString(){
        return "| No Order Found for the Requested Date";
    }
    
}
