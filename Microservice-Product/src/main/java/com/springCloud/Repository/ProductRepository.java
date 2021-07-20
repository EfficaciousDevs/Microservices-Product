package com.springCloud.Repository;

import com.springCloud.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findById(int id);
}
