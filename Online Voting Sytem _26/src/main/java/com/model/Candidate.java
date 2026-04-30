package com.model;

import javax.persistence.*;
@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String candidate; // Candidate name
    private int votes;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
