package org.me.learning.ecomproject1.controller;


import org.me.learning.ecomproject1.model.Product;
import org.me.learning.ecomproject1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {


//    Setter and Constructor injection is better
    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public  String greet (){
        return "Hello World";
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getAllProducts();

    }





}
