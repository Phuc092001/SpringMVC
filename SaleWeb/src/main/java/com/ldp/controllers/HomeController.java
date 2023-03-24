/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldp.controllers;

import com.ldp.pojo.Category;
import com.ldp.pojo.Product;
import com.ldp.service.CategoryService;
import com.ldp.service.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ACER
 */
@Controller
@ControllerAdvice
public class HomeController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    
    @ModelAttribute
    public void commonAttributes(Model model) {
        List<Category> cates = this.categoryService.getCategories();
        model.addAttribute("categories", cates);
    }

    @GetMapping(path = {"/", "/products"})
    public String index(Model model, @RequestParam Map<String, String> params) {
        List<Product> products = this.productService.getProducts(params);
        model.addAttribute("products", products);
        
        return "index";
    }
    
    @GetMapping(path = "/products/{productId}")
    public String details(Model model, 
            @PathVariable(value = "productId") int id) {
        model.addAttribute("product", this.productService.getProductById(id));
        return "product-detail";
    }
}
