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
}
