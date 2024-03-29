package com.springcourse.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springcourse.api.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByName(String name);

	@Query("SELECT u FROM usser u WHERE email = ?1 AND password = ?2")
	public Optional<User> login(String email, String password);
	
}
