package org.me.learning.ecomproject1.service;


import org.me.learning.ecomproject1.model.Product;
import org.me.learning.ecomproject1.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts(){
        return repo.findAll();

    }

    public Product getProdByID(int id) {
//        return repo.findById(id).orElse(new Product());   1
        return repo.findById(id).orElse(null);  //    2
    }

    public Product addProduct(Product prod, MultipartFile image) throws IOException {
        prod.setImageName(image.getOriginalFilename());
        prod.setImageType(image.getContentType());
        prod.setImageData(image.getBytes());
       return  repo.save(prod);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return  repo.save(product);
    }

    public void deleteProduct(int id) {
         repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return  repo.searchProducts(keyword);
    }
}
