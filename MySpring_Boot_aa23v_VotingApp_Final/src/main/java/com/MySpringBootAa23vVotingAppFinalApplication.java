package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.model.Candidate;
import com.model.User;
import com.repository.CandidateRepository;
import com.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.repository")
@EntityScan(basePackages = "com.model")
public class MySpringBootAa23vVotingAppFinalApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootAa23vVotingAppFinalApplication.class, args);
    }

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CandidateRepository canRepo;

    @Override
    public void run(String... args) throws Exception {

        // Admin user (let Hibernate generate ID)
        if (userRepo.count() == 0) {
            User admin = new User();
            admin.setEmail("admin");
            admin.setName("admin");
            admin.setPassword("admin");
            admin.setPhone("1234");
            admin.setRole("ROLE_ADMIN");
            userRepo.save(admin);
        }

        // Candidates
        if (canRepo.count() == 0) {

            Candidate c1 = new Candidate();
            c1.setCandidate("Modi Ji");
            c1.setVotes(0);
            canRepo.save(c1);

            Candidate c2 = new Candidate();
            c2.setCandidate("Yogi Ji");
            c2.setVotes(0);
            canRepo.save(c2);

            Candidate c3 = new Candidate();
            c3.setCandidate("Putin");
            c3.setVotes(0);
            canRepo.save(c3);

            Candidate c4 = new Candidate();
            c4.setCandidate("Donald Trump");
            c4.setVotes(0);
            canRepo.save(c4);
        }
    }
}
    
