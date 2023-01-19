package com.backFalahApp.BackFalahApp.controller;

import com.backFalahApp.BackFalahApp.Dto.CategoryDto;
import com.backFalahApp.BackFalahApp.model.Category;
import com.backFalahApp.BackFalahApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("/api")
public class CategoryController {

    private CategoryService categoryService;


    @Autowired
    public CategoryController(CategoryService theCategoryService) {
        categoryService = theCategoryService;
    }

    @GetMapping("/getcategories")
    public ResponseEntity<List<CategoryDto>> findAllCategory() {
        List<CategoryDto> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }


    @PostMapping("/createcategory")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody Category theCategory) {

        theCategory.setId(0);
        CategoryDto resultCategory = categoryService.createCategory(theCategory);
        return new ResponseEntity<>(resultCategory, HttpStatus.OK);

    }
}