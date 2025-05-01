package com.KCG.Online_Shopping_Products.entity;

import com.KCG.Online_Shopping_Products.entity.Enum.RoleType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true,nullable = false)
    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private RoleType role = RoleType.CUSTOMER;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;
}

