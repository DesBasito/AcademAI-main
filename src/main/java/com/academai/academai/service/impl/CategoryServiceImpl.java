package com.academai.academai.service.impl;

import com.academai.academai.dto.CategoryDto;
import com.academai.academai.entity.Category;
import com.academai.academai.repository.CategoryRepository;
import com.academai.academai.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAllCategoryDtos(){
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(this::convertToCategoryDto)
                .toList();
    }

    @Override
    public List<Long> getAllCategoryIdsIncludingSubcategories(Category category){
        List<Long> categoryIds = new ArrayList<>();
        categoryIds.add(category.getId());
        for (Category subCategory : category.getSubcategories()){
            categoryIds.addAll(getAllCategoryIdsIncludingSubcategories(subCategory));
        }
        return categoryIds;
    }

    @Override
    public Category getCategoryById(Long categoryId){
        return categoryRepository.findById(categoryId).orElseThrow(() -> new NoSuchElementException("Category not found"));
    }

    private CategoryDto convertToCategoryDto(Category category){
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .parentCategory(category.getParentCategory() != null
                        ? new CategoryDto(category.getParentCategory().getId(), category.getParentCategory().getName(), null, null)
                        : null)
                .subcategories(category.getSubcategories() != null? category.getSubcategories().stream().map(this::convertToCategoryDto).toList() : null)
                .build();
    }
}
