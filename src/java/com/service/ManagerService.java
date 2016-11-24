/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.DTO.ManufacturerDTO;
import com.DTO.ProductDTO;
import com.model.Manufacturer;
import com.model.Product;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Nguyen Xuan Hung
 */
@WebService(serviceName = "ManagerService")
public class ManagerService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "loadAllManufacturers")
    public List<ManufacturerDTO> loadAllManufacturers() {
        List<ManufacturerDTO> list = new ArrayList<>();
        EntityManager em = Persistence.createEntityManagerFactory("Bai1_ExamPU").createEntityManager();
        String hql = String.format("select a from %s a", Manufacturer.class.getName());
        List<Manufacturer> listManu = em.createQuery(hql).getResultList();
        for (Manufacturer it : listManu) {
            list.add(new ManufacturerDTO(it.getManufacturerID(), it.getManufacturerName()));
        }
        return list;
    }

    @WebMethod(operationName = "loadAllProducts")
    public List<ProductDTO> loadAllProducts() {
        List<ProductDTO> list = new ArrayList<>();
        EntityManager em = Persistence.createEntityManagerFactory("Bai1_ExamPU").createEntityManager();
        String hql = String.format("select a from %s a", Product.class.getName());
        List<Product> listPro = em.createQuery(hql).getResultList();
        for (Product it : listPro) {
            list.add(new ProductDTO(it.getProductID(), it.getProductName(), it.getCreatedDate().getTime(), it.getManufacturer().getManufacturerID(), it.getManufacturer().getManufacturerName()));
        }
        return list;
    }

    @WebMethod(operationName = "loadProductByID")
    public ProductDTO loadProductByID(String id) {
        EntityManager em = Persistence.createEntityManagerFactory("Bai1_ExamPU").createEntityManager();
        Product p = em.find(Product.class, id);
        if (p != null) {
            return new ProductDTO(p.getProductID(), p.getProductName(), p.getCreatedDate().getTime(), p.getManufacturer().getManufacturerID(), p.getManufacturer().getManufacturerName());
        }
        return null;
    }

    @WebMethod(operationName = "loadProductByManuID")
    public List<ProductDTO> loadProductByManuID(String id) {
        List<ProductDTO> list = new ArrayList<>();
        EntityManager em = Persistence.createEntityManagerFactory("Bai1_ExamPU").createEntityManager();
        String hql = String.format("select a from %s a where a.manufacturer.manufacturerID = :id", Product.class.getName());
        List<Product> listPro = em.createQuery(hql)
                .setParameter("id", id)
                .getResultList();
        for (Product it : listPro) {
            list.add(new ProductDTO(it.getProductID(), it.getProductName(), it.getCreatedDate().getTime(), it.getManufacturer().getManufacturerID(), it.getManufacturer().getManufacturerName()));
        }
        return list;
    }

    @WebMethod(operationName = "addNewProduct")
    public boolean addNewProduct(ProductDTO p) {
        EntityManager em = Persistence.createEntityManagerFactory("Bai1_ExamPU").createEntityManager();
        em.getTransaction().begin();
        Product pDaTonTai = em.find(Product.class, p.getProductID());
        if (pDaTonTai != null) {
            return false;
        }
        pDaTonTai = new Product(p.getProductID(), p.getProductName(), new Date(p.getCreatedDate()));
        pDaTonTai.setManufacturer(new Manufacturer(p.getManufacturerID(), p.getManufacturerName()));
        em.persist(pDaTonTai);
        em.getTransaction().commit();
        return true;
    }

    @WebMethod(operationName = "updateProduct")
    public boolean updateProduct(ProductDTO p) {
        EntityManager em = Persistence.createEntityManagerFactory("Bai1_ExamPU").createEntityManager();
        em.getTransaction().begin();
        Product pDaTonTai = em.find(Product.class, p.getProductID());
        if (pDaTonTai == null) {
            return false;
        }
        pDaTonTai.setProductName(p.getProductName());
        pDaTonTai.setCreatedDate(new Date(p.getCreatedDate()));
        pDaTonTai.setManufacturer(new Manufacturer(p.getManufacturerID(), p.getManufacturerName()));
        em.getTransaction().commit();
        return true;
    }
    @WebMethod(operationName = "deleteProduct")
    public boolean deleteProduct(String id) {
        EntityManager em = Persistence.createEntityManagerFactory("Bai1_ExamPU").createEntityManager();
        em.getTransaction().begin();
        Product pDaTonTai = em.find(Product.class, id);
        if (pDaTonTai == null) {
            return false;
        }
        em.remove(pDaTonTai);
        em.getTransaction().commit();
        return true;
    }
    

}
