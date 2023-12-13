package com.example.mlmsystem.service;

import org.springframework.stereotype.Service;

import com.example.mlmsystem.model.Referral;
import com.example.mlmsystem.repository.ReferralRepository;

@Service
public class ReferralService {

    private final ReferralRepository referralRepository;

    public ReferralService(ReferralRepository referralRepository) {
        this.referralRepository = referralRepository;
    }

    public Referral recordReferral(Referral referral) {
        // Additional validation if needed
        return referralRepository.save(referral);
    }
}