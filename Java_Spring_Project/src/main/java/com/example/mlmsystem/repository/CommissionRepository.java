package com.example.mlmsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mlmsystem.model.Commission;

public interface CommissionRepository extends JpaRepository<Commission, Long> {

	
}
