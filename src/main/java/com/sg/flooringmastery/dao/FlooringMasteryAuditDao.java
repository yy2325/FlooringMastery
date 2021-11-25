package com.sg.flooringmastery.dao;
import com.sg.flooringmastery.dao.exceptions.FlooringMasteryPersistenceException;
/**
 * This interface provides all the methods to be implemented in FlooringMasteryAuditDaoImpl
 * @author Yi Yang
 *
 */
public interface FlooringMasteryAuditDao {
    /**
     * Writes the entry to the audit log that tracks the events of the ordering program
     * @param entry
     * @throws FlooringMasteryPersistenceException 
     */
    public void writeAuditEntry(String entry) throws FlooringMasteryPersistenceException;
    
}
