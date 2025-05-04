package com.KCG.Online_Shopping_Products.mapper;

import com.KCG.Online_Shopping_Products.dto.request.CategoryRequest;
import com.KCG.Online_Shopping_Products.dto.response.CategoryResponse;
import com.KCG.Online_Shopping_Products.entity.Category;

public class CategoryMapper {

    public static Category toEntity(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        return category;
    }

    public static CategoryResponse toResponse(Category category) {
        return new CategoryResponse(category.getId(), category.getName());
    }
}
