/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldp.repository;

import com.ldp.pojo.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ACER
 */
public interface ProductRepository {
    List<Product> getProducts(Map<String, String> params);
    Product getProductById(int id);
    boolean addOrUpdateProduct(Product p);
    boolean deleteProduct(int id);
   
}
