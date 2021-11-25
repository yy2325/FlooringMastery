package com.sg.flooringmastery.dto;

/**
 * This enum converts the Month names into corresponding the order of the month
 * as well as the number of days in that month.
 * @author Yi Yang
 *
 */
public enum Months {
    JANUARY (1,31),
    FEBRUARY (2,28),
    MARCH (3,31),
    APRIL (4,30),
    MAY (5,31),
    JUNE (6,30),
    JULY (7,31),
    AUGUST (8,31),
    SEPTEMBER (9,30),
    OCTOBER (10,31),
    NOVEMBER (11,30),
    DECEMBER (12,31);
    
    public final int monthInNumber, maxNumberOfDays;
    /**
     * Constructs a new Months object
     * @param monthInNumber
     * @param maxNumberOfDays 
     */
    Months(int monthInNumber, int maxNumberOfDays){
       this.monthInNumber = monthInNumber;
       this.maxNumberOfDays = maxNumberOfDays;
    }
    /**
     * Gets the month in its number
     * @return number that corresponds to the month
     */
    public int getMonthInNumber() {
        return monthInNumber;
    }
    /**
     * Gets the number of days in that month
     * @return number of days in that month
     */
    public int getMaxNumberOfDays() {
        return maxNumberOfDays;
    }
    
    
}