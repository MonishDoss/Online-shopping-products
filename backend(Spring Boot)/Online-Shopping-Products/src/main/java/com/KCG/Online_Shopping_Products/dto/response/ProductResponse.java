package com.KCG.Online_Shopping_Products.dto.response;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String categoryName;
    private List<String> imagesBase64;

    public ProductResponse(Long id, String name, String description, double price, String categoryName, List<String> imagesBase64) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryName = categoryName;
        this.imagesBase64 = imagesBase64;
    }
}