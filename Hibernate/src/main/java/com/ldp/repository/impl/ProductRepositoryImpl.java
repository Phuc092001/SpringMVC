/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldp.repository.impl;

import com.ldp.hibernate.HibernateUtils;
import com.ldp.pojo.Product;
import com.ldp.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author ACER
 */
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Product> getProducts(Map<String, String> params) {
        try (Session s = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Product> q = b.createQuery(Product.class);
            Root root = q.from(Product.class);
            q.select(root);
            
            List<Predicate> predicates = new ArrayList<>();
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("name").as(String.class), 
                        String.format("%%%s%%", kw));
                predicates.add(p);
            }
            
            String fromPrice = params.get("fromPrice");
            if (fromPrice != null && !fromPrice.isEmpty()) {
                Predicate p = b.greaterThanOrEqualTo(root.get("price").as(Double.class), 
                        Double.parseDouble(fromPrice));
                predicates.add(p);
            } 
            
            String toPrice = params.get("toPrice");
            if (toPrice != null && !toPrice.isEmpty()) {
                Predicate p = b.lessThanOrEqualTo(root.get("price").as(Double.class), 
                        Double.parseDouble(toPrice));
                predicates.add(p);
            }
            
            q.where(predicates.toArray(Predicate[]::new));
            q.orderBy(b.desc(root.get("id")));
            
            Query query = s.createQuery(q);
            return query.getResultList();
        }
    }
    
}