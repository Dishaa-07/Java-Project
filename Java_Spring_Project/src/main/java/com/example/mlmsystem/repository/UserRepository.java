package com.example.mlmsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mlmsystem.model.User;

//UserRepository.java
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);
}
