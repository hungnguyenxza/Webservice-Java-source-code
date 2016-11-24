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
public class ManufacturerDTO {
    private String manufacturerID;
    
    private String manufacturerName;

    public ManufacturerDTO() {
    }

    public ManufacturerDTO(String manufacturerID, String manufacturerName) {
        this.manufacturerID = manufacturerID;
        this.manufacturerName = manufacturerName;
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
