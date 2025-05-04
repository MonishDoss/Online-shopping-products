package com.KCG.Online_Shopping_Products.service.Implements;

import com.KCG.Online_Shopping_Products.dto.request.CategoryRequest;
import com.KCG.Online_Shopping_Products.dto.response.CategoryResponse;
import com.KCG.Online_Shopping_Products.entity.Category;
import com.KCG.Online_Shopping_Products.exception.ResourceNotFoundException;
import com.KCG.Online_Shopping_Products.mapper.CategoryMapper;
import com.KCG.Online_Shopping_Products.repository.CategoryRepository;
import com.KCG.Online_Shopping_Products.service.Interface.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponse createCategory(CategoryRequest request) {
        Category category = CategoryMapper.toEntity(request);
        return CategoryMapper.toResponse(categoryRepository.save(category));
    }

    @Override
    public CategoryResponse updateCategory(Long id, CategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
        category.setName(request.getName());
        return CategoryMapper.toResponse(categoryRepository.save(category));
    }

    @Override
    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Category not found with id: " + id);
        }
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toResponse)
                .collect(Collectors.toList());
    }
}
