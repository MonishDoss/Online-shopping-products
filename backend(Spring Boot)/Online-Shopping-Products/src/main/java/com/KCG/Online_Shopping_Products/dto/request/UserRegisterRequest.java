package com.KCG.Online_Shopping_Products.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRegisterRequest {
    private String username;
    private String email;
    private String password;
    private String role;
}