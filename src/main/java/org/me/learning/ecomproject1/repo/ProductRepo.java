package org.me.learning.ecomproject1.repo;

import org.me.learning.ecomproject1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {


//    here we will use JPQL and it is similar to SQL
    @Query("SELECT p from Product p WHERE "
    + "LOWER(p.name) like LOWER(CONCAT( '%' ,:keyword, '%') ) OR "
    + "LOWER(p.brand) like LOWER(CONCAT( '%' ,:keyword, '%') ) OR "
    + "LOWER(p.description) like LOWER(CONCAT( '%' ,:keyword, '%') ) OR "
    + "LOWER(p.category) like LOWER(CONCAT( '%' ,:keyword, '%') )  "
    )
   List< Product> searchProducts(String keyword);
}
