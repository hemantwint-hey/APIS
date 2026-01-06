package org.example.ecommerce.controller;

import org.example.ecommerce.model.Category;
import org.example.ecommerce.service.CategoryService;
import org.example.ecommerce.service.CategoryServiceImpl;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }



    @PostMapping("/api/public/categories")
    public String createCtegory(@RequestBody Category category){
        categoryService.createCategory(category);
        return "Category Added Succesfully";
    }

}
