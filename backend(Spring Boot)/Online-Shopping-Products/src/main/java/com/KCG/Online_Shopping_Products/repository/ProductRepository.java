package com.KCG.Online_Shopping_Products.repository;

import com.KCG.Online_Shopping_Products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory_Id(Long categoryId);
}
