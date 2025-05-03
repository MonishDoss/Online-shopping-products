package com.KCG.Online_Shopping_Products.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RemoveFromCartRequest {
    private Long userId;
    private Long productId;
}