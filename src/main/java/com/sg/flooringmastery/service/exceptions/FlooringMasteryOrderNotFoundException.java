package com.sg.flooringmastery.service.exceptions;

/**
 * This class defines the FlooringMasteryOrderNotFoundException
 * and the error message
 * @author Yi Yang
 *
 */
public class FlooringMasteryOrderNotFoundException extends Exception{
    /**
     * Constructs a new FlooringMasteryOrderNotFoundException object given message
     * @param message 
     */
    public FlooringMasteryOrderNotFoundException(String message) {
        super(message);
    }
    /**
     * Constructs a new FlooringMasteryOrderNotFoundException object given
     * message and cause
     * @param message
     * @param cause 
     */
    public FlooringMasteryOrderNotFoundException(String message,
            Throwable cause) {
        super(message, cause);
    }
    /**
     * Prints out the error message
     * @return error message
     */
    @Override
    public String toString(){
        return "| Order Not Found";
    }
}
