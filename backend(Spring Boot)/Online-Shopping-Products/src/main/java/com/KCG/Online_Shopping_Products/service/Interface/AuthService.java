package com.KCG.Online_Shopping_Products.service.Interface;

import com.KCG.Online_Shopping_Products.dto.request.LoginRequest;
import com.KCG.Online_Shopping_Products.dto.request.UserRegisterRequest;
import com.KCG.Online_Shopping_Products.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse register(UserRegisterRequest request);
    AuthResponse login(LoginRequest request);
}