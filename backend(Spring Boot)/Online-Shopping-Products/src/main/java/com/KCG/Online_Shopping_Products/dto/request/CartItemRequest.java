package com.KCG.Online_Shopping_Products.dto.request;

import lombok.*;

@Getter
@Setter
@Data
public class CartItemRequest {
    private Long cartId;
    private Long productId;
    private int quantity;

    public CartItemRequest(Long cartId, Long productId, int quantity) {
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public CartItemRequest() {
    }

    @Override
    public String toString() {
        return "CartItemRequest{" +
                "cartId=" + cartId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
