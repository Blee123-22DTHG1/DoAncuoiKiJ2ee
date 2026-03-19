package bai4_qlsp_LeBinh.demo.service;

import bai4_qlsp_LeBinh.demo.model.Category;
import bai4_qlsp_LeBinh.demo.respository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public List<Category> getCategoriesByGroupId(Integer groupId) {
        return categoryRepository.findByGroup_Id(groupId);
    }

    public List<Category> getCategoriesByIds(List<Integer> ids) {
        return categoryRepository.findAllById(ids);
    }

    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }
}