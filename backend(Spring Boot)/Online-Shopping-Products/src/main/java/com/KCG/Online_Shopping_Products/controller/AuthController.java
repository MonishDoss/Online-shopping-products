package com.KCG.Online_Shopping_Products.controller;

import com.KCG.Online_Shopping_Products.dto.request.LoginRequest;
import com.KCG.Online_Shopping_Products.dto.request.UserRegisterRequest;
import com.KCG.Online_Shopping_Products.dto.response.AuthResponse;
import com.KCG.Online_Shopping_Products.service.Interface.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody UserRegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
}
