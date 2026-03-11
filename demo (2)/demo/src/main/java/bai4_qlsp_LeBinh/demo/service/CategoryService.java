package bai4_qlsp_LeBinh.demo.service;

import org.springframework.stereotype.Service;

import bai4_qlsp_LeBinh.demo.model.Category;
import bai4_qlsp_LeBinh.demo.respository.CategoryRepository;
import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}