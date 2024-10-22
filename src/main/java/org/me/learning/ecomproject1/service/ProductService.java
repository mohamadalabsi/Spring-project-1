package org.me.learning.ecomproject1.service;


import org.me.learning.ecomproject1.model.Product;
import org.me.learning.ecomproject1.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts(){
        return repo.findAll();

    }
}
