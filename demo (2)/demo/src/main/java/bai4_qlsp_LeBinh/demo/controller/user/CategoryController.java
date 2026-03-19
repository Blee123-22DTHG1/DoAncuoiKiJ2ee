package bai4_qlsp_LeBinh.demo.controller.user;

import bai4_qlsp_LeBinh.demo.model.Category;
import bai4_qlsp_LeBinh.demo.model.CategoryGroup;
import bai4_qlsp_LeBinh.demo.service.CategoryGroupService;
import bai4_qlsp_LeBinh.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryGroupService categoryGroupService;

    @GetMapping
    public String showAllCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        List<CategoryGroup> groups = categoryGroupService.getAllGroups();

        model.addAttribute("categories", categories);
        model.addAttribute("groups", groups);
        model.addAttribute("selectedGroup", null);

        return "user/category/list";
    }

    @GetMapping("/group/{groupId}")
    public String showCategoriesByGroup(@PathVariable Integer groupId, Model model) {
        List<Category> categories = categoryService.getCategoriesByGroupId(groupId);
        List<CategoryGroup> groups = categoryGroupService.getAllGroups();
        CategoryGroup selectedGroup = categoryGroupService.getById(groupId);

        model.addAttribute("categories", categories);
        model.addAttribute("groups", groups);
        model.addAttribute("selectedGroup", selectedGroup);

        return "user/category/list";
    }
}