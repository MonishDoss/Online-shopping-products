package com.KCG.Online_Shopping_Products.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartItemRequest {
    private Long cartId;
    private Long productId;
    private int quantity;
}
