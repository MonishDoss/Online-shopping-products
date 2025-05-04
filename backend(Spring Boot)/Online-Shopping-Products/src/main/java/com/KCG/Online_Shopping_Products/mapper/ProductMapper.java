package com.KCG.Online_Shopping_Products.mapper;

import com.KCG.Online_Shopping_Products.dto.request.ProductRequest;
import com.KCG.Online_Shopping_Products.dto.response.ProductResponse;
import com.KCG.Online_Shopping_Products.entity.Category;
import com.KCG.Online_Shopping_Products.entity.Product;
import com.KCG.Online_Shopping_Products.entity.ProductImage;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static Product toEntity(ProductRequest request, Category category, List<byte[]> imageDataList) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setCategory(category);

        List<ProductImage> productImages = toProductImages(imageDataList, product);
        product.setImages(productImages);

        return product;
    }

    public static ProductResponse toDto(Product product) {
        List<String> base64Images = product.getImages().stream()
                .map(img -> Base64.getEncoder().encodeToString(img.getData()))
                .collect(Collectors.toList());

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getName(),
                base64Images
        );
    }

    public static List<ProductImage> toProductImages(List<byte[]> imageDataList, Product product) {
        return imageDataList.stream()
                .map(data -> {
                    ProductImage image = new ProductImage();
                    image.setData(data);
                    image.setProduct(product);
                    return image;
                })
                .collect(Collectors.toList());
    }
}
