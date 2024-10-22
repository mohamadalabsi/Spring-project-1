package org.me.learning.ecomproject1.repo;

import org.me.learning.ecomproject1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
