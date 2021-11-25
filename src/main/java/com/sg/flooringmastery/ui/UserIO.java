package com.sg.flooringmastery.ui;
import java.math.BigDecimal;
/**
 * 
 * The interface provides list of methods to be implemented for UserIOImpl
 * @author Yi Yang
 *
 */

public interface UserIO {
    /**
     * A very simple method that takes in a message to display on the console 
     * and then waits for a integer answer from the user to return.
     * @param msg String of information to display to the user.
     */
    void print(String msg);
    /**
     *
     * A simple method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter a double
     * to be returned as the answer to that message.
     *
     * @param prompt - String explaining what information you want from the user.
     * @return the answer to the message as double
     */
    double readDouble(String prompt) throws NumberFormatException;
    /**
     *
     * A slightly more complex method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter a double
     * within the specified min/max range to be returned as the answer to that message.
     *
     * @param prompt - String explaining what information you want from the user.
     * @param min - minimum acceptable value for return
     * @param max - maximum acceptable value for return
     * @return an double value as an answer to the message prompt within the min/max range
     */
    double readDouble(String prompt, double min, double max) throws NumberFormatException;
    /**
     *
     * A simple method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter an integer
     * to be returned as the answer to that message.
     *
     * @param prompt - String explaining what information you want from the user.
     * @return the answer to the message as integer
     */
    int readInt(String prompt) throws NumberFormatException;
    /**
     *
     * A slightly more complex method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter an integer
     * within the specified min/max range to be returned as the answer to that message.
     *
     * @param prompt - String explaining what information you want from the user.
     * @param min - minimum acceptable value for return
     * @param max - maximum acceptable value for return
     * @return an integer value as an answer to the message prompt within the min/max range
     */
    int readInt(String prompt, int min, int max) throws NumberFormatException;
    /**
     *
     * A simple method that takes in a message to display on the console, 
     * and then waits for an answer from the user to return.
     *
     * @param prompt - String explaining what information you want from the user.
     * @return the answer to the message as string
     */
    String readString(String prompt);
    /**
     * A slightly more complex method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter an string
     * that can be compared to the current string to be returned as the answer to that message.
     * @param prompt - String explaining what information you want from the user.
     * @param compare - The string to be used as comparison
     * @param toThis - The string entered
     * @return  the answer to the message as string
     */
    String readString(String prompt, String compare, String toThis);
    /**
     * A slightly more complex method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter a double
     * within the specified min/max range to be returned as the answer to that message.
     * @param prompt - String explaining what information you want from the user.
     * @param min - minimum acceptable value for return
     * @param compare - String to be compared
     * @param toThis -  The string entered
     * @return the answer to the message as string
     * @throws NumberFormatException 
     */
    double readDouble(String prompt, double min, Double compare, String toThis) throws NumberFormatException;
    /**
     *
     * A simple method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter an BigDecimal
     * to be returned as the answer to that message.
     *
     * @param prompt - String explaining what information you want from the user.
     * @return the answer to the message as BigDecimal
     */
    BigDecimal readBigDecimal (String prompt) throws NumberFormatException;
    /**
     * A slightly more complex method that takes in a message to display on the console, 
     * and continually reprompts the user with that message until they enter an BigDecimal
     * within the old value to be returned as the answer to that message.
     * @param prompt - String explaining what information you want from the user.
     * @param oldValue - BigDecimal to be compared with what is entered
     * @return the answer to the message as BigDecimal
     * @throws NumberFormatException 
     */
    BigDecimal readBigDecimal(String prompt, BigDecimal oldValue) throws NumberFormatException;
  
}
