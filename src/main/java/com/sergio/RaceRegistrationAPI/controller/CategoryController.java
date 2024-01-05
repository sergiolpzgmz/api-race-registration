package com.sergio.RaceRegistrationAPI.controller;

import com.sergio.RaceRegistrationAPI.dto.CategoryDTO;
import com.sergio.RaceRegistrationAPI.entity.Race;
import com.sergio.RaceRegistrationAPI.service.CategoryService;
import com.sergio.RaceRegistrationAPI.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    RaceService raceService;

    @PostMapping("category")
    public ResponseEntity<CategoryDTO>newCategory(@RequestBody CategoryDTO categoryDTO) {
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
}
