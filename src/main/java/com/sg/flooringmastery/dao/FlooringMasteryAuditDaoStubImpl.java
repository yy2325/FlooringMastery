package com.sg.flooringmastery.dao;
import com.sg.flooringmastery.dao.exceptions.FlooringMasteryPersistenceException;
/**
 * This is a stub implementation for FlooringMasteryAuditDao
 * for testing purposes.
 * @author Yi Yang
 *
 */
public class FlooringMasteryAuditDaoStubImpl implements FlooringMasteryAuditDao{
    /**
     * Writes the entry to the audit log that tracks the events of the ordering program
     * @param entry
     * @throws FlooringMasteryPersistenceException 
     */
    @Override
    public void writeAuditEntry(String entry) throws FlooringMasteryPersistenceException {
        
    }
    
}
