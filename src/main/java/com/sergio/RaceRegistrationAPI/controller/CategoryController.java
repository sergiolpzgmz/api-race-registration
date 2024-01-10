package com.sergio.RaceRegistrationAPI.controller;

import com.sergio.RaceRegistrationAPI.dto.CategoryDTO;
import com.sergio.RaceRegistrationAPI.entity.Category;
import com.sergio.RaceRegistrationAPI.entity.Race;
import com.sergio.RaceRegistrationAPI.exception.ApiRequestExceptionNotFound;
import com.sergio.RaceRegistrationAPI.service.CategoryService;
import com.sergio.RaceRegistrationAPI.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    RaceService raceService;

    @PostMapping("category")
    public ResponseEntity<CategoryDTO> newCategory(@RequestBody CategoryDTO categoryDTO) {
        try {
            Race race = raceService.findRaceById(categoryDTO.getRaceId());
            categoryService.saveCategory(categoryDTO, race);
            return ResponseEntity.status(HttpStatus.CREATED).body(categoryDTO);

        } catch (HttpMessageNotReadableException e) {
            throw new HttpMessageNotReadableException(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
    }

    @PutMapping("category/{categoryId}")
    public ResponseEntity<Category> updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable Long categoryId) {
        try {
            Category categoryToUpdate = categoryService.findCategoryById(categoryId);

            if (categoryToUpdate == null) {
                throw new ApiRequestExceptionNotFound("Category not found with id: " + categoryId);
            } else {
                categoryService.updateCategoryIngo(categoryDTO, categoryToUpdate);
                return ResponseEntity.status(HttpStatus.CREATED).body(categoryToUpdate);
            }

        } catch (HttpMessageNotReadableException e) {
            throw new HttpMessageNotReadableException(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        }
    }

    @DeleteMapping("category/{categoryId}")
    public ResponseEntity<Void>deleteCategory(@PathVariable Long categoryId){
        Category categoryToDelete = categoryService.findCategoryById(categoryId);
        if(categoryToDelete == null){
            throw new ApiRequestExceptionNotFound("Category not found with id: " + categoryId);
        } else{
            categoryService.deleteCategory(categoryToDelete);
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("category/{categoryId}")
    public ResponseEntity<Category>getCategoryById(@PathVariable Long categoryId){
        Category category = categoryService.findCategoryById(categoryId);

        if(category == null){
            throw new ApiRequestExceptionNotFound("Category not found with id: " + categoryId);
        }
        return ResponseEntity.ok(category);
    }

    @GetMapping("categories/byRace/{raceId}")
    public ResponseEntity<List<Category>>getRaceCategories(@PathVariable Long raceId){
        List<Category>getCategories = categoryService.getRaceCategories(raceId);
        if(getCategories.isEmpty()){
            throw new ApiRequestExceptionNotFound("No categories found");
        }
        return ResponseEntity.ok(getCategories);
    }
}
