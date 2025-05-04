package com.KCG.Online_Shopping_Products.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class UserOrderSummary {
    private Long userId;
    private String username;
    private List<OrderSummary> orders;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<OrderSummary> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderSummary> orders) {
        this.orders = orders;
    }
}
