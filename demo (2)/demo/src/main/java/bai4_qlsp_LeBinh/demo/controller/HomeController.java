package bai4_qlsp_LeBinh.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "home"; // Phải khớp với tên file home.html
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login"; // Phải khớp với tên file login.html
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "auth/register";
    }
}