package com.KCG.Online_Shopping_Products.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Long categoryId;
}