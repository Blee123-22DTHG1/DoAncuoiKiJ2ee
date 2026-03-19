package bai4_qlsp_LeBinh.demo.controller.advice;

import bai4_qlsp_LeBinh.demo.service.CategoryGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class CategoryGroupAdvice {

    @Autowired
    private CategoryGroupService categoryGroupService;

    @ModelAttribute
    public void addGlobalAttributes(Model model) {
        model.addAttribute("group_category", categoryGroupService.getAllGroups());
    }
}
