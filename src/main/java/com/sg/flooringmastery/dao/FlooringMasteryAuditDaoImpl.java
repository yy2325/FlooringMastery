package com.sg.flooringmastery.dao;
import com.sg.flooringmastery.dao.exceptions.FlooringMasteryPersistenceException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
/**
 * This class implements the methods provided in FlooringMasteryAuditDao interface,
 * it keeps an audit log using java DateTime API to track events of the ordering program
 * @author Yi Yang
 *
 */
public class FlooringMasteryAuditDaoImpl implements FlooringMasteryAuditDao {
    public static final String AUDIT_FILE = "audit.txt";
    /**
     * Writes the entry to the audit log that tracks the events of the ordering program
     * @param entry
     * @throws FlooringMasteryPersistenceException 
     */
    @Override
    public void writeAuditEntry(String entry) throws FlooringMasteryPersistenceException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new FlooringMasteryPersistenceException("Could not persist audit information.", e);
        }
        LocalDateTime timestamp = LocalDateTime.now();
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
        out.close();
    }

    
}
