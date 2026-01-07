package org.example.ecommerce.controller;

import org.example.ecommerce.model.Category;
import org.example.ecommerce.service.CategoryService;
import org.example.ecommerce.service.CategoryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
@RestController
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/categories")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> allCategories = categoryService.getAllCategories();
        return new ResponseEntity<>(allCategories,HttpStatus.OK);
    }

    @PostMapping("/api/public/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return new ResponseEntity<>("Category Added Succesfully",HttpStatus.CREATED);
    }

    @DeleteMapping("/api/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
    try {
        String status=categoryService.deleteCategory(categoryId);
//        return ResponseEntity.status(HttpStatus.OK).body(status);
//        return ResponseEntity.ok(status);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
    catch(ResponseStatusException e){
        return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }
    @PutMapping("/api/public/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category,
                                                 @PathVariable Long categoryId ){
        try{
            Category savedCategory=categoryService.updateCategory(category,categoryId);
            return new ResponseEntity<>("Cstegory with category id "+categoryId, HttpStatus.OK);

        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }
}
