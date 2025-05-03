package com.KCG.Online_Shopping_Products.repository;

import com.KCG.Online_Shopping_Products.entity.Order;
import com.KCG.Online_Shopping_Products.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrderId(Long orderId);
}
