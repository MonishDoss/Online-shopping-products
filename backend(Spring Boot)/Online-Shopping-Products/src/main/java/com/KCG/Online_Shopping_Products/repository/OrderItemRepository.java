package com.KCG.Online_Shopping_Products.repository;

import com.KCG.Online_Shopping_Products.entity.Order;
import com.KCG.Online_Shopping_Products.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrderId(Long orderId);
}
