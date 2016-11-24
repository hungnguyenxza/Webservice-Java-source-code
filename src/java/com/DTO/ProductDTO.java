/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DTO;

/**
 *
 * @author Nguyen Xuan Hung
 */
public class ProductDTO {
    private String productID;
    
    private String productName;
    
    private long createdDate;
    
    private String manufacturerID;
    
    private String manufacturerName;

    public ProductDTO() {
    }

    public ProductDTO(String productID, String productName, long createdDate, String manufacturerID, String manufacturerName) {
        this.productID = productID;
        this.productName = productName;
        this.createdDate = createdDate;
        this.manufacturerID = manufacturerID;
        this.manufacturerName = manufacturerName;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public String getManufacturerID() {
        return manufacturerID;
    }

    public void setManufacturerID(String manufacturerID) {
        this.manufacturerID = manufacturerID;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }
    
    
}
