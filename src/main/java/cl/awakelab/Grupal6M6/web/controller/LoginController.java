package cl.awakelab.Grupal6M6.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public String login(HttpServletRequest request, Model model, Principal user) {
        if (user != null) {
            return "dashboard";
        }
        return "login";
    }
}