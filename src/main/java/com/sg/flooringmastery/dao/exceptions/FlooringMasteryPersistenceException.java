package com.sg.flooringmastery.dao.exceptions;

/**
 * This class defines FlooringMasteryPersistenceException and the error message
 * @author Yi Yang
 *
 */
public class FlooringMasteryPersistenceException extends Exception {
    /**
     * Constructs a new FlooringMasteryPersistenceException given message
     * @param message 
     */
    public FlooringMasteryPersistenceException(String message) {
        super(message);
    }
    /**
     * Constructs a new FlooringMasteryPersistenceException given message and cause
     * @param message
     * @param cause 
     */
    public FlooringMasteryPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
    
}