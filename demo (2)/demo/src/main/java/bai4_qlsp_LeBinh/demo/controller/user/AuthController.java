package bai4_qlsp_LeBinh.demo.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "user/auth/login";
    }

    @GetMapping("/register")
    public String register() {
        return "user/auth/register";
    }
}