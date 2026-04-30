package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.User;
@Repository
public interface UserRepository  extends JpaRepository<User, Integer>{
	
	@Query("select v from User v where v.email = :email")
	public User getUserByEmail(@Param("email") String email);
	
	

	
}
