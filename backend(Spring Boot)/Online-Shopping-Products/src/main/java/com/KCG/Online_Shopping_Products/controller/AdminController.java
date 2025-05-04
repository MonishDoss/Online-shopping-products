package com.KCG.Online_Shopping_Products.controller;

import com.KCG.Online_Shopping_Products.dto.request.ProductRequest;
import com.KCG.Online_Shopping_Products.dto.request.CategoryRequest;
import com.KCG.Online_Shopping_Products.dto.response.CategoryResponse;
import com.KCG.Online_Shopping_Products.entity.Product;
import com.KCG.Online_Shopping_Products.entity.ProductImage;
import com.KCG.Online_Shopping_Products.service.Interface.ImageService;
import com.KCG.Online_Shopping_Products.service.Interface.ProductService;
import com.KCG.Online_Shopping_Products.service.Interface.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ImageService imageService;

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody ProductRequest request) {
        Product product = productService.createProduct(request);

        if (request.getImagesBase64() != null && !request.getImagesBase64().isEmpty()) {
            for (String base64Image : request.getImagesBase64()) {
                byte[] imageBytes = imageService.decodeBase64(base64Image);
                ProductImage productImage = new ProductImage();
                productImage.setData(imageBytes);
                productImage.setProduct(product);
                productImage.setType("image/jpeg");
                product.getImages().add(productImage);
            }
        }

        return ResponseEntity.ok(productService.saveProductWithImages(product));  // Update this method to handle saving product and images
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductRequest request) {
        Product product = productService.updateProduct(id, request);

        if (request.getImagesBase64() != null && !request.getImagesBase64().isEmpty()) {
            product.getImages().clear();
            for (String base64Image : request.getImagesBase64()) {
                byte[] imageBytes = imageService.decodeBase64(base64Image);
                ProductImage productImage = new ProductImage();
                productImage.setData(imageBytes);
                productImage.setProduct(product);
                productImage.setType("image/jpeg");
                product.getImages().add(productImage);
            }
        }

        return ResponseEntity.ok(productService.saveProductWithImages(product));  // Update method to handle images
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/categories")
    public ResponseEntity<CategoryResponse> addCategory(@RequestBody CategoryRequest request) {
        return ResponseEntity.ok(categoryService.createCategory(request));
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(@PathVariable Long id, @RequestBody CategoryRequest request) {
        return ResponseEntity.ok(categoryService.updateCategory(id, request));
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}
