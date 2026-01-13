package org.example.ecommerce.controller;

import jakarta.validation.Valid;
import org.example.ecommerce.model.Category;
import org.example.ecommerce.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService categoryService;

    // Constructor Injection (Best Practice)
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // GET all categories
    @GetMapping("/public/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> allCategories = categoryService.getAllCategories();
        return ResponseEntity.ok(allCategories);
    }

    // CREATE category
    @PostMapping(
            value = "/public/categories",
            consumes = "application/json"
    )
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>("Category Added Successfully", HttpStatus.CREATED);
    }

    // UPDATE category
    @PutMapping(
            value = "/public/categories/{categoryId}",
            consumes = "application/json"
    )
    public ResponseEntity<String> updateCategory(
            @RequestBody Category category,
            @PathVariable Long categoryId) {

        categoryService.updateCategory(category, categoryId);
        return ResponseEntity.ok("Category updated successfully");
    }

    // DELETE category
    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        String status = categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok(status);
    }
}
