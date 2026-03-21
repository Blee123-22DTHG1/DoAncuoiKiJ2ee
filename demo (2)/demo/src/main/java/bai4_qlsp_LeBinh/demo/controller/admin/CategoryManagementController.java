package bai4_qlsp_LeBinh.demo.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bai4_qlsp_LeBinh.demo.model.Category;
import bai4_qlsp_LeBinh.demo.service.CategoryGroupService;
import bai4_qlsp_LeBinh.demo.service.CategoryService;

@Controller
@RequestMapping("/admin/category")
public class CategoryManagementController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryGroupService categoryGroupService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("page", "category/category-list");
        model.addAttribute("title", "Quản lý danh mục");
        return "layouts/admin-layout"; // Trả về file giao diện
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("groups", categoryGroupService.getAllGroups());
        model.addAttribute("page", "category/category-form");
        model.addAttribute("title", "Thêm danh mục");
        return "layouts/admin-layout";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("category") Category category, RedirectAttributes ra) {
        categoryService.saveCategory(category);
        ra.addFlashAttribute("success", "Thao tác thành công!");
        // SỬA TẠI ĐÂY: Quay lại trang danh sách theo đường dẫn URL
        return "redirect:/admin/category"; 
    }
    
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes ra) {
        categoryService.deleteCategory(id);
        ra.addFlashAttribute("success", "Đã xóa danh mục!");
        // Quay lại trang danh sách theo đường dẫn URL
        return "redirect:/admin/category";
    }
    
    // Đừng quên hàm Edit nhé Bình!
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("category", categoryService.getCategoryById(id));
        model.addAttribute("groups", categoryGroupService.getAllGroups());
        model.addAttribute("page", "category/category-form");
        model.addAttribute("title", "Chỉnh sửa danh mục");
        return "layouts/admin-layout";
    }
}