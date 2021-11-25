package com.sg.flooringmastery.dto;
import java.math.BigDecimal;
/**
 * This class represents a product, as well as the costs
 * assciated with such product.
 * @author Yi Yang
 */
public class Product {
    private String productType;
    private BigDecimal costPSF;
    private BigDecimal laborCostPSF;
    /**
     * Constructs a new Product object
     * @param productType
     * @param costPSF
     * @param laborCostPSF 
     */
    public Product(String productType, String costPSF,String laborCostPSF ) {
        this.productType = productType;
        this.costPSF = new BigDecimal(costPSF);
        this.laborCostPSF = new BigDecimal(laborCostPSF);
    }
    /**
     * Returns the product type
     * @return product type
     */
    public String getProductType() {
        return productType;
    }
    /**
     * Returns the costpsf
     * @return cost psf
     */
    public BigDecimal getCostPSF() {
        return costPSF;
    }
    /**
     * Returns the labor cost psf
     * @return labor cost psf
     */
    public BigDecimal getLaborCostPSF() {
        return laborCostPSF;
    }
    /**
     * Sets the product type
     * @param productType 
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }
    /**
     * Sets the cost psf
     * @param costPSF 
     */
    public void setCostPSF(BigDecimal costPSF) {
        this.costPSF = costPSF;
    }
    /**
     * Sets the labor cost psf
     * @param laborCostPSF 
     */
    public void setLaborCostPSF(BigDecimal laborCostPSF) {
        this.laborCostPSF = laborCostPSF;
    } 
    
}
