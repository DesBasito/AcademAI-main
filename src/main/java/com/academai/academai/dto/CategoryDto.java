package com.academai.academai.dto;

import com.academai.academai.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;
    private CategoryDto parentCategory;
    private List<CategoryDto> subcategories;
}
