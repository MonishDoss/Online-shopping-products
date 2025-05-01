package com.KCG.Online_Shopping_Products.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String role;
}