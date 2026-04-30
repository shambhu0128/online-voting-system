package com.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Candidate;
import com.service.CandidateService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CandidateService canServ;

    @GetMapping("/dashboard")
    public String dashboard(Model m, Principal p) {

        List<Candidate> candidates = canServ.getAllCandidates();
        m.addAttribute("candidates", candidates);
        m.addAttribute("c1", canServ.getNumOfVotes("Modi ji"));
        m.addAttribute("c2", canServ.getNumOfVotes("Yogi ji"));
        m.addAttribute("c3", canServ.getNumOfVotes("Putin"));
        m.addAttribute("c4", canServ.getNumOfVotes("Donald Trump"));

        m.addAttribute("title", "ADMIN DASHBOARD");

        return "admin/dashboard";
    }
}
