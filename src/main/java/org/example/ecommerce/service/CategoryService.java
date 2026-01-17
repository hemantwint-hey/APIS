package org.example.ecommerce.service;

import org.example.ecommerce.model.Category;
import org.example.ecommerce.payload.CategoryDTO;
import org.example.ecommerce.payload.CategoryResponse;

import java.util.List;

public interface CategoryService {
     CategoryResponse getAllCategories();
     CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO deleteCategory(Long categoryId);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
