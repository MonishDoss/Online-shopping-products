package com.KCG.Online_Shopping_Products.dto;

import lombok.*;

import com.KCG.Online_Shopping_Products.Enum.RoleType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private RoleType role;
}