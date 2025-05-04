package com.KCG.Online_Shopping_Products.service.Implements;

import com.KCG.Online_Shopping_Products.dto.request.ProductRequest;
import com.KCG.Online_Shopping_Products.entity.Category;
import com.KCG.Online_Shopping_Products.entity.Product;
import com.KCG.Online_Shopping_Products.entity.ProductImage;
import com.KCG.Online_Shopping_Products.repository.CategoryRepository;
import com.KCG.Online_Shopping_Products.repository.ProductRepository;
import com.KCG.Online_Shopping_Products.repository.ProductImageRepository;
import com.KCG.Online_Shopping_Products.service.Interface.ImageService;
import com.KCG.Online_Shopping_Products.service.Interface.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductImageRepository productImageRepository;
    private final ImageService imageService;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ProductImageRepository productImageRepository, ImageService imageService) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productImageRepository = productImageRepository;
        this.imageService = imageService;
    }

    @Transactional
    @Override
    public Product createProduct(ProductRequest request) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setCategory(category);

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

        return saveProductWithImages(product);
    }

    @Transactional
    @Override
    public Product updateProduct(Long id, ProductRequest request) {
        Product product = getProductById(id);
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setCategory(category);

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

        return saveProductWithImages(product);
    }

    @Transactional
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategory_Id(categoryId);
    }

    @Transactional
    @Override
    public Product saveProductWithImages(Product product) {
        return productRepository.save(product);
    }

    private boolean isImageBase64Valid(String base64Image) {
        return base64Image != null && !base64Image.isEmpty();
    }
}
