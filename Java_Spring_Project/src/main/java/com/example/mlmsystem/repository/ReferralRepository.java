package com.example.mlmsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mlmsystem.model.Referral;

public interface ReferralRepository extends JpaRepository<Referral, Long> {

    
}