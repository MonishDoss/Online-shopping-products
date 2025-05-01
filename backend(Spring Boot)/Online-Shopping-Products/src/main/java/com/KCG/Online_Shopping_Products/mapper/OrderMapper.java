package com.KCG.Online_Shopping_Products.mapper;

import com.KCG.Online_Shopping_Products.dto.response.OrderResponse;
import com.KCG.Online_Shopping_Products.entity.Order;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMapper {
    public static OrderResponse toDto(Order order) {
        List<Long> productIds = order.getOrderItems().stream()
                .map(orderItem -> orderItem.getProduct().getId())
                .collect(Collectors.toList());

        return new OrderResponse(
                order.getId(),
                order.getUser().getId(),
                productIds,
                order.getStatus().name()
        );
    }
}
