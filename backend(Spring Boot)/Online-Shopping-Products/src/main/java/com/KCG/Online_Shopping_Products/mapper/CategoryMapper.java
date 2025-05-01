package com.KCG.Online_Shopping_Products.mapper;

import com.KCG.Online_Shopping_Products.dto.response.CategoryResponse;
import com.KCG.Online_Shopping_Products.entity.Category;

public class CategoryMapper {
    public static CategoryResponse toDto(Category category) {
        return new CategoryResponse(category.getId(), category.getName());
    }
}