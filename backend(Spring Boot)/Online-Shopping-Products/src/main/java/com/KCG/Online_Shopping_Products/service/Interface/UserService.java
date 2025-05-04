package com.KCG.Online_Shopping_Products.service.Interface;

import com.KCG.Online_Shopping_Products.dto.response.UserOrderSummary;

import java.util.List;

public interface UserService {
    List<UserOrderSummary> getUsersWithOrderSummaries();
}