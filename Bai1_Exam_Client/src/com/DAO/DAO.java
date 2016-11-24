/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.DAO;

import com.service.ProductDTO;

/**
 *
 * @author Nguyen Xuan Hung
 */
public class DAO {

    public static boolean addNewProduct(com.service.ProductDTO arg0) {
        com.service.ManagerService_Service service = new com.service.ManagerService_Service();
        com.service.ManagerService port = service.getManagerServicePort();
        return port.addNewProduct(arg0);
    }

    public static boolean deleteProduct(java.lang.String arg0) {
        com.service.ManagerService_Service service = new com.service.ManagerService_Service();
        com.service.ManagerService port = service.getManagerServicePort();
        return port.deleteProduct(arg0);
    }

    public static java.util.List<com.service.ManufacturerDTO> loadAllManufacturers() {
        com.service.ManagerService_Service service = new com.service.ManagerService_Service();
        com.service.ManagerService port = service.getManagerServicePort();
        return port.loadAllManufacturers();
    }

    public static java.util.List<com.service.ProductDTO> loadAllProducts() {
        com.service.ManagerService_Service service = new com.service.ManagerService_Service();
        com.service.ManagerService port = service.getManagerServicePort();
        return port.loadAllProducts();
    }

    public static ProductDTO loadProductByID(java.lang.String arg0) {
        com.service.ManagerService_Service service = new com.service.ManagerService_Service();
        com.service.ManagerService port = service.getManagerServicePort();
        return port.loadProductByID(arg0);
    }

    public static java.util.List<com.service.ProductDTO> loadProductByManuID(java.lang.String arg0) {
        com.service.ManagerService_Service service = new com.service.ManagerService_Service();
        com.service.ManagerService port = service.getManagerServicePort();
        return port.loadProductByManuID(arg0);
    }

    public static boolean updateProduct(com.service.ProductDTO arg0) {
        com.service.ManagerService_Service service = new com.service.ManagerService_Service();
        com.service.ManagerService port = service.getManagerServicePort();
        return port.updateProduct(arg0);
    }
    
}
