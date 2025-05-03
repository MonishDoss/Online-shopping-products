package com.KCG.Online_Shopping_Products.repository;

import com.KCG.Online_Shopping_Products.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
