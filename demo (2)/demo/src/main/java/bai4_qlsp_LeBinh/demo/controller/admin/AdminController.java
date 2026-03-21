package bai4_qlsp_LeBinh.demo.controller.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import bai4_qlsp_LeBinh.demo.model.Account;
import bai4_qlsp_LeBinh.demo.model.Role;
import bai4_qlsp_LeBinh.demo.service.AccountService;

@Controller
public class AdminController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/admin")
    public String adminDashboard(Model model) {
        model.addAttribute("page", "dashboard");
        model.addAttribute("title", "Dashboard");
        model.addAttribute("breadcrumb", "Dashboard");
        return "layouts/admin-layout";
    }




    // @GetMapping("/admin/accounts")
    // public String listAccounts(Model model) {
    //     model.addAttribute("accounts", accountService.findAll());
    //     return "admin/account-list";
    // }
}
