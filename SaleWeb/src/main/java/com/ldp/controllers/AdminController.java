/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldp.controllers;

import com.ldp.pojo.Product;
import com.ldp.service.ProductService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ACER
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ProductService productService;
    
    @RequestMapping("/products")
    public String addProduct(Model model, 
            @ModelAttribute(value = "product") @Valid Product p,
            BindingResult rs) {
        if (rs.hasErrors())
            return "products";
        
        if (this.productService.addOrUpdateProduct(p) == true)
            return "redirect:/";
        else
            model.addAttribute("errMsg", "Something wrong!!!");
        
        return "products";
    }
    
    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("product", new Product());
        return "products";
    }
    
   
}
