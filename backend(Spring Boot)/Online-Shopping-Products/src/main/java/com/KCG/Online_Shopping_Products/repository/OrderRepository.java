package com.KCG.Online_Shopping_Products.repository;

import com.KCG.Online_Shopping_Products.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
}
