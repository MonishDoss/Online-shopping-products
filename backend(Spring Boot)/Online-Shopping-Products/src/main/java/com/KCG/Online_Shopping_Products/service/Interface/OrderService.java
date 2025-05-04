package com.KCG.Online_Shopping_Products.service.Interface;

import com.KCG.Online_Shopping_Products.Enum.OrderStatus;
import com.KCG.Online_Shopping_Products.dto.response.OrderDetailsResponse;
import com.KCG.Online_Shopping_Products.entity.Order;

import java.util.List;

public interface OrderService {
    Order placeOrder(Long userId);
    List<Order> getOrdersByUser(Long userId);
    OrderDetailsResponse getOrderDetailsById(Long orderId);
    void updateOrderStatus(Long orderId, OrderStatus status);

}