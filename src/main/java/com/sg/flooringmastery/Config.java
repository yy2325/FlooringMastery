package com.sg.flooringmastery;
import com.sg.flooringmastery.dao.exceptions.FlooringMasteryPersistenceException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
/**
 * This class reads and uses the mode and password,
 * in order to run the controller.
 * @author Yi Yang
 */
public class Config {
    private String mode;
    private String password;
    private static final String CONFIG = "configuration.txt"; //using data store in the txt
    private static final String DELIMITER = "::";
    /**
     * Constructs a new Config object
     * @throws FlooringMasteryPersistenceException 
     */
    public Config() throws FlooringMasteryPersistenceException {
        Scanner scanner;
        try {
        scanner = new Scanner(new BufferedReader(new FileReader(CONFIG)));//scans for the existence of the file
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException("Could not load the vending into memory", e);
        }
        String currentLine; //reads the file
        String[] currentTokens;
        while(scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER); //splits the txt file into mode and password
            this.mode = currentTokens[0];
            this.password = currentTokens[1];
        }
        scanner.close();
        
    }
    /**
     * Gets the mode token
     * @return mode token
     */
    public String getMode() {
        return mode;
    }
    /**
     * Sets the mode token
     * @param mode 
     */
    public void setMode(String mode) {
        this.mode = mode;
    }
    /**
     * Gets the password
     * @return password
     */
    public String getPassword() {
        return password;
    }
    /**
     * Sets the password
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    } 
    
}
