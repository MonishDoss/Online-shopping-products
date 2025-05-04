package com.KCG.Online_Shopping_Products.service.Interface;

import com.KCG.Online_Shopping_Products.dto.request.CategoryRequest;
import com.KCG.Online_Shopping_Products.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse createCategory(CategoryRequest request);
    CategoryResponse updateCategory(Long id, CategoryRequest request);
    void deleteCategory(Long id);
    List<CategoryResponse> getAllCategories();
}
