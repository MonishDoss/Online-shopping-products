package com.KCG.Online_Shopping_Products.service.Interface;

import com.KCG.Online_Shopping_Products.dto.request.CartItemRequest;
import com.KCG.Online_Shopping_Products.entity.Cart;

public interface CartService {
    Cart getCartByUserId(Long userId);
    Cart addItemToCart(Long userId, CartItemRequest request);
    void removeItemFromCart(Long userId, Long productId);
    void clearCart(Long userId);
}