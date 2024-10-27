package org.me.learning.ecomproject1.controller;


import org.me.learning.ecomproject1.model.Product;
import org.me.learning.ecomproject1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/product")
    public ResponseEntity <?> addProduct(@RequestPart Product product , @RequestPart MultipartFile imageFile ){ // we will use RequestPart instead of RequestBody because the image has a different format and we will get it as parts , but with RequestBody except the hole object as json format , and also the names should be the same as the frontend because it is two requests

        try {
            Product product1=  productService.addProduct(product, imageFile);
            return new ResponseEntity<> (product1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<> (e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }




}
