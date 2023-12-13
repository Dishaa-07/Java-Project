package com.example.mlmsystem.service;

import org.springframework.stereotype.Service;

import com.example.mlmsystem.model.Commission;
import com.example.mlmsystem.model.User;
import com.example.mlmsystem.repository.CommissionRepository;

@Service
public class CommissionService {

    private final CommissionRepository commissionRepository;

    public CommissionService(CommissionRepository commissionRepository) {
        this.commissionRepository = commissionRepository;
    }

    public Commission calculateCommission(User user, double amount, int level) {
        // Additional commission calculation logic if needed
        Commission commission = new Commission();
        commission.setUser(user);
        commission.setAmount(amount * getCommissionRate(level));
        commission.setLevel(level);
        return commissionRepository.save(commission);
    }

    private double getCommissionRate(int level) {
        // Define commission rates based on the MLM structure
        switch (level) {
            case 1:
                return 0.10; // 10% for level 1
            case 2:
                return 0.05; // 5% for level 2
            default:
                return 0.0; // No commission for other levels
        }
    }
}