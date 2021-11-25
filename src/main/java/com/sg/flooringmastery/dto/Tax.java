package com.sg.flooringmastery.dto;
import java.math.BigDecimal;
/**
 * This class calculates the tax to be charged with the product
 * @author Yi Yang
 */
public class Tax {
    private String state;
    private String stateAbbreviation;
    private BigDecimal taxRate;
    /**
     * Constructs a new Tax object
     * @param state
     * @param stateAbbreviation
     * @param taxVariable 
     */
    public Tax(String state,String stateAbbreviation ,BigDecimal taxVariable) {
        this.state = state;
        this.stateAbbreviation= stateAbbreviation;
        this.taxRate = taxVariable;
    }
    /**
     * Returns the state
     * @return state
     */
    public String getState() {
        return state;
    }
    /**
     * Returns the tax rate
     * @return tax rate
     */
    public BigDecimal getTaxRate() {
        return taxRate;
    }
    /**
     * Sets the state
     * @param state 
     */
    public void setState(String state) {
        this.state = state;
    }
    /**
     * Sets the tax rate
     * @param taxRate 
     */
    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }
    /**
     * Returns the state Abbreviation
     * @return abbreviation
     */
    public String getStateAbbreviation() {
        return stateAbbreviation;
    }
    /**
     * Sets the state abbreviation
     * @param stateAbbreviation 
     */
    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }
}