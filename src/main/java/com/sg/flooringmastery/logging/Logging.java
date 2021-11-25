package com.sg.flooringmastery.logging;
import com.sg.flooringmastery.dao.FlooringMasteryAuditDao;
import com.sg.flooringmastery.dao.FlooringMasteryAuditDaoImpl;
import com.sg.flooringmastery.dao.exceptions.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.service.exceptions.FlooringMasteryContainsInvalidInputException;
import com.sg.flooringmastery.service.exceptions.FlooringMasteryNoOrdersForTheRequestedDateException;
import com.sg.flooringmastery.service.exceptions.FlooringMasteryOrderNotFoundException;
import org.aspectj.lang.JoinPoint;
/**
 * This class logs and tracks events of the ordering program
 * in case of an event that causes an exception
 * were to occur.
 * @author Yi Yang
 */
public class Logging {
    FlooringMasteryAuditDao auditDao;
    int count = 0;
    int invalidCount = 0;
    int orderNotFoundCount = 0;
    int dateCount = 0;
    /**
     * Constructs a new Logging object
     * @param auditDao 
     */
    public Logging(FlooringMasteryAuditDaoImpl auditDao) {
        this.auditDao = auditDao;
    }
    /**
     * Using aspectj to create audit entries.
     * @param jp
     * @param ex
     * @throws FlooringMasteryContainsInvalidInputException
     * @throws FlooringMasteryNoOrdersForTheRequestedDateException
     * @throws FlooringMasteryOrderNotFoundException 
     */
    public void createAuditEntry(JoinPoint jp, Throwable ex) throws FlooringMasteryContainsInvalidInputException, FlooringMasteryNoOrdersForTheRequestedDateException, FlooringMasteryOrderNotFoundException {
        if (ex instanceof FlooringMasteryContainsInvalidInputException ){
            count = invalidCount++;
        }else if (ex instanceof FlooringMasteryOrderNotFoundException){
            count = orderNotFoundCount++;
        }else{
            count = dateCount++;
        }
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + " : " + ex.toString() + " (" + count + ") ";
        for (Object currentArg : args) {
            auditEntry += ": " + currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (FlooringMasteryPersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
    
}
