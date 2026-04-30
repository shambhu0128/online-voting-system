package com.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.model.User;
import com.model.Candidate;
import com.service.UserService;
import com.service.CandidateService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userServ;

    @Autowired
    private CandidateService canServ;

    // ===================== DASHBOARD =====================
    @GetMapping("/dashboard")
    public String userDashboard(Model model, Principal principal) {
        String email = principal.getName();
        User user = userServ.getUserByEmail(email);
        List<Candidate> candidates = canServ.getAllCandidates();
        model.addAttribute("user", user);
        model.addAttribute("candidates", candidates);
        model.addAttribute("title", "USER DASHBOARD");
        return "user/dashboard";
    }

    // ===================== VOTE =====================
    @PostMapping("/vote")
    public String vote(@RequestParam("candidateId") Integer candidateId,
                       Principal principal,
                       HttpSession session) {

        String email = principal.getName();
        User user = userServ.getUserByEmail(email);

        if (user.isHasVoted()) {
            session.setAttribute("vmsg", "You have already voted!");
            return "redirect:/user/dashboard";
        }

        Candidate candidate = canServ.getCandidateById(candidateId);
        if (candidate == null) {
            session.setAttribute("vmsg", "Candidate not found!");
            return "redirect:/user/dashboard";
        }

        candidate.setVotes(candidate.getVotes() + 1);
        canServ.addCandidate(candidate);

        user.setHasVoted(true);
        userServ.addUser(user);

        session.setAttribute("vmsg", "Vote submitted successfully!");
        return "redirect:/user/dashboard";
    }

    // ===================== REGISTRATION (POST only) =====================
    // Handle registration form submission
    @PostMapping("/createuser")
    public String createUser(
            @RequestParam String name,
            @RequestParam String password,
            @RequestParam String email,
            @RequestParam String phone,
            Model model) {

        // Save the user
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password); // plain text for now
        user.setRole("ROLE_NORMAL"); // assign normal role
        userServ.addUser(user);

        // Show success message on the same page
        model.addAttribute("msg", "Registration successful!");

        // Return the same registration page
        return "redirect:/user/register";
    }
}
