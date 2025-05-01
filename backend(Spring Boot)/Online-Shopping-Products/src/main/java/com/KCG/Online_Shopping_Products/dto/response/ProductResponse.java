package com.KCG.Online_Shopping_Products.dto.response;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String categoryName;
    private List<String> imagesBase64;
}