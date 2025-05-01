package com.KCG.Online_Shopping_Products.mapper;

import com.KCG.Online_Shopping_Products.dto.response.UserResponse;
import com.KCG.Online_Shopping_Products.entity.User;

public class UserMapper {
    public static UserResponse toDto(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole().name()
        );
    }
}
