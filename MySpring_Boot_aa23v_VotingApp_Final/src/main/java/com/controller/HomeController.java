package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes; 

import com.model.User;
import com.service.UserService;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;  // ✅ Inject UserService

    // -------------------- GET MAPPINGS --------------------

    @GetMapping("/")
    public String home(Model m) {
        m.addAttribute("title", "HOME");
        return "home";
    }

    @GetMapping("/signin")
    public String login(Model m) {
        m.addAttribute("title", "SIGNIN");
        return "signin";
    }

    @GetMapping("/register")
    public String register(Model m) {
        m.addAttribute("title", "REGISTER");
        m.addAttribute("user", new User());  // ✅ Needed for form binding
        return "register";
    }

    @GetMapping("/about")
    public String about(Model m) {
        m.addAttribute("title", "ABOUT");
        return "about";
    }

    // -------------------- POST MAPPING --------------------
    // Handles registration form submission
    @PostMapping("/createuser")
    public String registerUser(@ModelAttribute("user") User user,RedirectAttributes redirectAttributes) {
        try {
            user.setRole("ROLE_NORMAL");   // default role
            user.setHasVoted(false);       // initial value
            userService.addUser(user);     // save to DB

            redirectAttributes.addFlashAttribute("msg", "Registration successful! Please login.");
            return "redirect:/register";     // redirect to login page
        } catch (Exception e) {
        	 redirectAttributes.addFlashAttribute("msg", "Error: " + e.getMessage());
            return "redirect:/register";             // show registration page again if error
        }
    }
}
