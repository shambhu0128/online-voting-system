package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    @Query("SELECT COALESCE(c.votes, 0) FROM Candidate c WHERE LOWER(c.candidate) = LOWER(:candidate)")
    Integer getNumOfVotes(@Param("candidate") String candidate);
}
