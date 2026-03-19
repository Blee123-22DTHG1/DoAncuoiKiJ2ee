package bai4_qlsp_LeBinh.demo.service;

import bai4_qlsp_LeBinh.demo.model.CategoryGroup;
import bai4_qlsp_LeBinh.demo.respository.CategoryGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryGroupService {

    @Autowired
    private CategoryGroupRepository categoryGroupRepository;

    public List<CategoryGroup> getAllGroups() {
        return categoryGroupRepository.findAll();
    }

    public CategoryGroup getById(Integer id) {
        return categoryGroupRepository.findById(id).orElse(null);
    }

    public void save(CategoryGroup categoryGroup) {
        categoryGroupRepository.save(categoryGroup);
    }

    public void deleteById(Integer id) {
        categoryGroupRepository.deleteById(id);
    }
}