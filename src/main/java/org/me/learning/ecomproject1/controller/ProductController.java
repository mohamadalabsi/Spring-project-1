package org.me.learning.ecomproject1.controller;


import org.me.learning.ecomproject1.model.Product;
import org.me.learning.ecomproject1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {


//    Setter and Constructor injection is better
    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public ResponseEntity < List<Product>> getProducts(){
        return new  ResponseEntity<> (productService.getAllProducts(), HttpStatus.OK); // if you want to return specific response

    }


    @GetMapping("/product/{id}")
    public ResponseEntity<Product >getProductById(@PathVariable int id){
//        now here if you do not use response entity either you fetch the object or nullable object , but with response entity u can do the following and you either get the object or nothing (null)
//    return productService.getProdByID(id);   1

//        2
        Product product = productService.getProdByID(id);
        if (product != null) {
            return new  ResponseEntity<> ( product, HttpStatus.OK);
        }
        else
            return new ResponseEntity<> (HttpStatus.NOT_FOUND);

    }





}
