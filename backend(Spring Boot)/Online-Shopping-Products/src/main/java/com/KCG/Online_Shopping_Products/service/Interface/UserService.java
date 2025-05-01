package com.KCG.Online_Shopping_Products.service.Interface;

public interface UserService {
    UserResponse register(UserRequest request);
    UserResponse getById(Long id);
}
