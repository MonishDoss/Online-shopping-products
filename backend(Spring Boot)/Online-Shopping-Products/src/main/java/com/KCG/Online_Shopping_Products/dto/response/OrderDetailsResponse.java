package com.KCG.Online_Shopping_Products.dto.response;

import com.KCG.Online_Shopping_Products.entity.Product;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


public class OrderDetailsResponse {
    private Long orderId;
    private LocalDateTime orderDate;
    private String status;
    private List<Product> products;

    public OrderDetailsResponse(Long orderId, LocalDateTime orderDate, String status, List<Product> products) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.status = status;
        this.products = products;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public OrderDetailsResponse() {
    }
}