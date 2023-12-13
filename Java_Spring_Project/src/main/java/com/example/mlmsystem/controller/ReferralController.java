package com.example.mlmsystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mlmsystem.model.Referral;
import com.example.mlmsystem.service.ReferralService;

@RestController
@RequestMapping("/api/referrals")
public class ReferralController {

    private final ReferralService referralService;

    public ReferralController(ReferralService referralService) {
        this.referralService = referralService;
    }

    @PostMapping("/record")
    public ResponseEntity<Referral> recordReferral(@RequestBody Referral referral) {
        Referral recordedReferral = referralService.recordReferral(referral);
        return ResponseEntity.ok(recordedReferral);
    }
}