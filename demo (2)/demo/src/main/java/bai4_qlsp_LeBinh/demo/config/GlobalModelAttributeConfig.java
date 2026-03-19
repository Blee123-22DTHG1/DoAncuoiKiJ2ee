package bai4_qlsp_LeBinh.demo.config;

import bai4_qlsp_LeBinh.demo.service.CategoryGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalModelAttributeConfig {

    @Autowired
    private CategoryGroupService categoryGroupService;

    @ModelAttribute
    public void addGlobalAttributes(Model model) {
        model.addAttribute("groupCategories", categoryGroupService.getAllGroups());
    }
}