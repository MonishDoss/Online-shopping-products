package com.KCG.Online_Shopping_Products.mapper;

import com.KCG.Online_Shopping_Products.dto.response.OrderSummary;
import com.KCG.Online_Shopping_Products.dto.response.UserOrderSummary;
import com.KCG.Online_Shopping_Products.entity.Order;
import com.KCG.Online_Shopping_Products.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserOrderMapper {

    public static UserOrderSummary toUserOrderSummary(User user) {
        UserOrderSummary summary = new UserOrderSummary();
        summary.setUserId(user.getId());
        summary.setUsername(user.getEmail());
        summary.setOrders(
                user.getOrders().stream()
                        .map(UserOrderMapper::toOrderSummary)
                        .collect(Collectors.toList())
        );
        return summary;
    }

    public static OrderSummary toOrderSummary(Order order) {
        OrderSummary orderSummary = new OrderSummary();
        orderSummary.setOrderId(order.getId());
        orderSummary.setStatus(order.getStatus().name()); // if using enum
        orderSummary.setOrderDate(order.getDate());
        return orderSummary;
    }

    public static List<UserOrderSummary> toUserOrderSummaryList(List<User> users) {
        return users.stream()
                .map(UserOrderMapper::toUserOrderSummary)
                .collect(Collectors.toList());
    }
}