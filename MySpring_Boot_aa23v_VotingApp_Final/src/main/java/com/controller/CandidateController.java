package com.controller;

import java.security.Principal;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Candidate;
import com.model.User;
import com.service.CandidateService;
import com.service.UserService;

@Controller
public class CandidateController {

    @Autowired
    private CandidateService canServ;

    @Autowired
    private UserService userServ;

  //  @PostMapping("/addcandidate")
    //public String addCandidate(@RequestParam("candidate") String candidate,
         //                      HttpSession session) {

        // Fetch the candidate from DB
      //  Candidate selectedCan = canServ.getCandidateByCandidate(candidate);

       // if (selectedCan == null) {
          //  session.setAttribute("vmsg", "Candidate not found!");
          //  return "redirect:/user/";
      //  }

        // Increment votes
      //  selectedCan.setVotes(selectedCan.getVotes() + 1);

        // Save the same candidate object
      //  canServ.addCandidate(selectedCan);

        //session.setAttribute("vmsg", "Successfully Voted...");
       // return "redirect:/user/";
   // }


}
