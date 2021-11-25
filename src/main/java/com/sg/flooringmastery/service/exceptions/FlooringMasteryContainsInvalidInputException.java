package com.sg.flooringmastery.service.exceptions;

/**
 * This class defines the FlooringMasteryContainsInvalidInputException
 * and the error message
 * @author Yi Yang
 *
 */
public class FlooringMasteryContainsInvalidInputException extends Exception {
    /**
     * Constructs a new FlooringMasteryContainsInvalidInputException object given message
     * @param message 
     */
    public FlooringMasteryContainsInvalidInputException(String message) {
        super(message);
    }
    /**
     * Constructs a new FlooringMasteryContainsInvalidInputException object given
     * message and cause
     * @param message
     * @param cause 
     */
    public FlooringMasteryContainsInvalidInputException(String message,
            Throwable cause) {
        super(message, cause);
    }
    /**
     * Prints out the error message
     * @return error message
     */
    @Override
    public String toString(){
        return "| Contains Invalid Input";
    }
   
    
}
