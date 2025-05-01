package com.KCG.Online_Shopping_Products.repository;

import java.util.Optional;

import com.KCG.Online_Shopping_Products.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}

