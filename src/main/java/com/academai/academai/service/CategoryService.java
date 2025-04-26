package com.academai.academai.service;

import com.academai.academai.dto.CategoryDto;
import com.academai.academai.entity.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategoryDtos();

    List<Long> getAllCategoryIdsIncludingSubcategories(Category category);

    Category getCategoryById(Long categoryId);
}
