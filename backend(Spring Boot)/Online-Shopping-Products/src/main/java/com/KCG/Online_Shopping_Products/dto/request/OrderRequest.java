package com.KCG.Online_Shopping_Products.dto.request;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderRequest {
    private Long userId;
    private List<Long> productIds;
}
