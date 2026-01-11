package org.example.ecommerce.service;

import org.example.ecommerce.model.Category;
import org.example.ecommerce.repositories.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    // Constructor Injection (BEST PRACTICE)
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Category not found with id " + categoryId
                        )
                );

        categoryRepository.delete(category);
        return "Category with categoryId " + categoryId + " deleted successfully";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {

        Category existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Category not found with id " + categoryId
                        )
                );

        existingCategory.setCategoryName(category.getCategoryName());
        return categoryRepository.save(existingCategory);
    }
}
