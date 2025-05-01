package com.KCG.Online_Shopping_Products.dto;

import com.KCG.Online_Shopping_Products.Enum.OrderStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDTO {
    private Long id;
    private LocalDateTime date;
    private OrderStatus status;
    private Double total;
    private Long userId;
    private List<OrderItemDTO> items;
}