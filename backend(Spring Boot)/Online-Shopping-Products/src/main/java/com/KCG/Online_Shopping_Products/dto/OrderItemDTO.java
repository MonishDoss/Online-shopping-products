package com.KCG.Online_Shopping_Products.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItemDTO {
    private Long productId;
    private String productName;
    private Integer quantity;
    private Double price;
}