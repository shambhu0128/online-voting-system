package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Candidate;
import com.repository.CandidateRepository;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepo;

    public List<Candidate> getAllCandidates() {
        return candidateRepo.findAll();
    }

    public Candidate getCandidateById(Integer id) {
        return candidateRepo.findById(id).orElse(null);
    }

    public Candidate addCandidate(Candidate candidate) {
        return candidateRepo.save(candidate);
    }

    public int getNumOfVotes(String candidateName) {
        Integer votes = candidateRepo.getNumOfVotes(candidateName);
        return votes != null ? votes : 0;
    }
}
