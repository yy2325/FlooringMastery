package com.sg.flooringmastery.dto;
import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * This class represents the order which an user puts in,
 * including all the details of the order
 * @author Yi Yang
 *
 */
public class Order {
    private final int orderNumber;
    private final String date;
    private String customerName;
    private BigDecimal area;
    private BigDecimal materialCost;
    private BigDecimal laborCost;
    private BigDecimal taxCharged;
    private BigDecimal total;
    private String state;
    private String stateAbbreviation;
    private BigDecimal taxRate;
    private String productType;
    private BigDecimal costPSF;
    private BigDecimal laborCostPSF;
    /**
     * Constructs a new Order object
     * @param orderNumber
     * @param date 
     */
    public Order(int orderNumber, String date) {
        this.orderNumber = orderNumber;
        this.date = date;
    }
    /**
     * Returns the date
     * @return date
     */
    public String getDate() {
        return date;
    }
    /**
     * Returns the customer name
     * @return name
     */
    public String getCustomerName() {
        return customerName;
    }
    /**
     * Sets the customer name
     * @param customerName 
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    /**
     * Returns the area
     * @return area
     */
    public BigDecimal getArea() {
        return area;
    }
    /**
     * Sets the area
     * @param area 
     */
    public void setArea(BigDecimal area) {
        this.area = area;
    }
    /**
     * Returns the material cost
     * @return 
     */
    public BigDecimal getMaterialCost() {
        return materialCost;
    }
    /**
     * Sets the material cost
     * @param materialCost 
     */
    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }
    /**
     * Returns the labor cost
     * @return labor cost
     */
    public BigDecimal getLaborCost() {
        return laborCost;
    }
    /**
     * Sets the labor cost
     * @param laborCost 
     */
    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }
    /**
     * Returns the tax charged
     * @return tax
     */
    public BigDecimal getTaxCharged() {
        return taxCharged;
    }
    /**
     * Sets how much tax to be charged
     * @param taxCharged 
     */
    public void setTaxCharged(BigDecimal taxCharged) {
        this.taxCharged = taxCharged;
    }
    /**
     * Returns total price
     * @return total price
     */
    public BigDecimal getTotal() {
        return total;
    }
    /**
     * Sets total price
     * @param total 
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    /**
     * Returns the state
     * @return state
     */
    public String getState() {
        return state;
    }
    /**
     * Returns order number
     * @return order number
     */
    public int getOrderNumber() {
        return orderNumber;
    }
    /**
     * Returns state abbreviation
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
    /**
     * Sets the state
     * @param state 
     */
    public void setState(String state) {
        this.state = state;
    }
    /**
     * Returns the tax rate
     * @return tax rate
     */
    public BigDecimal getTaxRate() {
        return taxRate;
    }
    /**
     * Sets the tax rate
     * @param taxRate 
     */
    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }
    /**
     * Returns the product type
     * @return product type
     */
    public String getProductType() {
        return productType;
    }
    /**
     * Sets the product type
     * @param productType 
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }
    /**
     * Returns the costpsf
     * @return costpsf
     */
    public BigDecimal getCostPSF() {
        return costPSF;
    }
    /**
     * Sets the costpfg
     * @param costPSF 
     */
    public void setCostPSF(BigDecimal costPSF) {
        this.costPSF = costPSF;
    }
    /**
     * Returns the labor costpsf
     * @return labor costpsf
     */
    public BigDecimal getLaborCostPSF() {
        return laborCostPSF;
    }
    /**
     * Sets the labor costpsf
     * @param laborCostPSF 
     */
    public void setLaborCostPSF(BigDecimal laborCostPSF) {
        this.laborCostPSF = laborCostPSF;
    }
    /**
     * Calculates other values
     */
    public void calculateOtherValues() {
        BigDecimal temp = this.area.multiply(this.costPSF);
        setMaterialCost(temp.setScale(2,RoundingMode.HALF_UP));
        BigDecimal temp2= this.area.multiply(this.laborCostPSF);
        setLaborCost(temp2.setScale(2,RoundingMode.HALF_UP));
        BigDecimal temp3 = this.materialCost.add(this.laborCost);
        setTotal(temp3.setScale(2,RoundingMode.HALF_UP));
        BigDecimal temp4 = this.taxRate.multiply(this.total);
        setTaxCharged(temp4.setScale(2,RoundingMode.HALF_UP));
    }
    
    /**
     * Prints out all the info in a string
     * @return string
     */ 
    @Override
    public String toString(){
        return  "Order details: Order Number: " +
                this.orderNumber + " | Customer Name: " +
                this.customerName + " | State Abbreviation: " +
                this.stateAbbreviation + " | State: " +
                this.state + " | Tax Rate: " +
                this.taxRate + " | Product Type: " +
                this.productType + " | Area: " +
                this.area + " square feet | Cost Per Square Foot: $" +
                this.costPSF + " | Labor Cost Per Square Foot: $" +
                this.laborCostPSF + " | Material Cost: $" +
                this.materialCost + " | Labor Cost: $" +
                this.laborCost + " | Tax Charged $" +
                this.taxCharged + " | Total: $" +
                this.total;
    }
}
