package com.KCG.Online_Shopping_Products.dto.request;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductRequest {
    private String name;
    private String description;
    private double price;
    private Long categoryId;
    private List<String> imagesBase64;
}
