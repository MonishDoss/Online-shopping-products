package com.KCG.Online_Shopping_Products.util;

import com.KCG.Online_Shopping_Products.dto.*;
import com.KCG.Online_Shopping_Products.entity.*;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    public static UserDTO toUserDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        return dto;
    }

    public static ProductDTO toProductDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setCategoryId(product.getCategory().getId());
        return dto;
    }

    public static CategoryDTO toCategoryDTO(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }

    public static OrderItemDTO toOrderItemDTO(OrderItem item) {
        OrderItemDTO dto = new OrderItemDTO();
        dto.setProductId(item.getProduct().getId());
        dto.setProductName(item.getProduct().getName());
        dto.setQuantity(item.getQuantity());
        dto.setPrice(item.getPrice());
        return dto;
    }

    public static OrderDTO toOrderDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setDate(order.getDate());
        dto.setStatus(order.getStatus());
        dto.setTotal(order.getTotal());
        dto.setUserId(order.getUser().getId());

        List<OrderItemDTO> itemDTOs = order.getOrderItems().stream()
                .map(Mapper::toOrderItemDTO)
                .collect(Collectors.toList());
        dto.setItems(itemDTOs);

        return dto;
    }
}
