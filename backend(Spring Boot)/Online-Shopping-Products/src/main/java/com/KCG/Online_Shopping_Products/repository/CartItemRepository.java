package com.KCG.Online_Shopping_Products.repository;

import com.KCG.Online_Shopping_Products.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {}