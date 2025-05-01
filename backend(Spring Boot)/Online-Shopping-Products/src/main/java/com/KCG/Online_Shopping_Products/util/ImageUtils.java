package com.KCG.Online_Shopping_Products.util;

import com.KCG.Online_Shopping_Products.entity.Product;
import com.KCG.Online_Shopping_Products.entity.ProductImage;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageUtils {

    public static List<ProductImage> toProductImages(MultipartFile[] files, Product product) throws IOException {
        List<ProductImage> images = new ArrayList<>();
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                ProductImage image = new ProductImage();
                image.setName(file.getOriginalFilename());
                image.setType(file.getContentType());
                image.setData(file.getBytes());
                image.setProduct(product);
                images.add(image);
            }
        }
        return images;
    }
}
