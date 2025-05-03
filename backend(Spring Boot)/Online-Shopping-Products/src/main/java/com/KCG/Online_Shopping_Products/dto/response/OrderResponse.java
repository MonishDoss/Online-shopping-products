package com.KCG.Online_Shopping_Products.dto.response;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderResponse {
    private Long id;
    private Long userId;
    private List<Long> productIds;
    private String orderStatus;

    public OrderResponse(Long id, Long userId, List<Long> productIds, String orderStatus) {
        this.id = id;
        this.userId = userId;
        this.productIds = productIds;
        this.orderStatus = orderStatus;
    }
}
