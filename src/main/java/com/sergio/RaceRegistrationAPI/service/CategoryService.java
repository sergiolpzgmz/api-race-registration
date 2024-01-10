package com.sergio.RaceRegistrationAPI.service;

import com.sergio.RaceRegistrationAPI.dto.CategoryDTO;
import com.sergio.RaceRegistrationAPI.entity.Category;
import com.sergio.RaceRegistrationAPI.entity.Race;
import com.sergio.RaceRegistrationAPI.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Transactional
    public Category saveCategory(CategoryDTO categoryDTO, Race race) {
        Category newCategory = new Category(race, categoryDTO.getCategoryName(), categoryDTO.getDistance(), categoryDTO.getStartTime());
        return categoryRepository.save(newCategory);
    }

    @Transactional
    public Category updateCategoryIngo(CategoryDTO categoryDTO, Category categoryToUpdate) {
        categoryToUpdate.setCategoryName(categoryDTO.getCategoryName());
        categoryToUpdate.setDistance(categoryDTO.getDistance());
        categoryToUpdate.setStartTime(categoryDTO.getStartTime());
        return categoryRepository.save(categoryToUpdate);
    }

    @Transactional
    public void deleteCategory(Category category) {
        categoryRepository.delete(category);
    }

    @Transactional(readOnly = true)
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Category> getRaceCategories(Long raceId) {
        return categoryRepository.findCategoriesByRaceId(raceId);
    }

}
