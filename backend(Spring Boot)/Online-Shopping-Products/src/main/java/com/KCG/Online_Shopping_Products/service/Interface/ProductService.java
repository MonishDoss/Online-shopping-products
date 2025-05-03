package com.KCG.Online_Shopping_Products.service.Interface;

import com.KCG.Online_Shopping_Products.dto.request.ProductRequest;
import com.KCG.Online_Shopping_Products.entity.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductRequest request);
    Product updateProduct(Long id, ProductRequest request);
    void deleteProduct(Long id);
    Product getProductById(Long id);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(Long categoryId);
}