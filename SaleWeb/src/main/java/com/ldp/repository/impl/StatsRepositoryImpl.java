///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.ldp.repository.impl;
//
//import com.ldp.hibernatedemo.HibernateUtils;
//import com.ldp.pojo.Category;
//import com.ldp.pojo.OrderDetail;
//import com.ldp.pojo.Product;
//import com.ldp.pojo.SaleOrder;
//import com.ldp.repository.StatsRepository;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import javax.persistence.Query;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import org.hibernate.Session;
//import org.springframework.stereotype.Repository;
//
///**
// *
// * @author ACER
// */
//@Repository
//public class StatsRepositoryImpl implements StatsRepository {
//
//    @Override
//    public List<Object[]> statsCategory() {
//        try (Session session = HibernateUtils.getFactory().openSession()) {
//            CriteriaBuilder b = session.getCriteriaBuilder();
//            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
//            
//            Root rootP = q.from(Product.class);
//            Root rootC = q.from(Category.class);
//            q.where(b.equal(rootP.get("categoryId"), rootC.get("id")));
//            
//            q.multiselect(rootC.get("id"), rootC.get("name"), b.count(rootP.get("id")));
//            q.groupBy(rootC.get("id"));
//            
//            Query query = session.createQuery(q);
//            return query.getResultList();
//        }
//    }
//
//    @Override
//    public List<Object[]> statsRevenue(Date fromDate, Date toDate) {
//        try (Session session = HibernateUtils.getFactory().openSession()) {
//            CriteriaBuilder b = session.getCriteriaBuilder();
//            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
//            
//            Root rootP = q.from(Product.class);
//            Root rootD = q.from(OrderDetail.class);
//            Root rootO = q.from(SaleOrder.class);
//            
//            List<Predicate> predicates = new ArrayList<>();
//            predicates.add(b.equal(rootD.get("productId"), rootP.get("id")));
//            predicates.add( b.equal(rootD.get("orderId"), rootO.get("id")));
//            
//            q.multiselect(rootP.get("id"), rootP.get("name"), 
//                    b.sum(b.prod(rootD.get("num"), rootD.get("unitPrice"))));
//            
//            if (fromDate != null)
//                predicates.add(b.greaterThanOrEqualTo(rootO.get("createdDate").as(Date.class), fromDate));
//            
//            if (toDate != null)
//                predicates.add(b.lessThanOrEqualTo(rootO.get("createdDate").as(Date.class), toDate));
//            
//            q.where(predicates.toArray(Predicate[]::new));
//            
//            q.groupBy(rootP.get("id"));
//            q.orderBy(b.desc(rootP.get("id")));
//            
//            Query query = session.createQuery(q);
//            return query.getResultList();
//        }
//    }
//}
//
