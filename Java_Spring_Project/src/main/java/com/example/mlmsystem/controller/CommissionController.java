package com.example.mlmsystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mlmsystem.model.Commission;
import com.example.mlmsystem.model.User;
import com.example.mlmsystem.service.CommissionService;
import com.example.mlmsystem.service.UserService;

@RestController
@RequestMapping("/api/commissions")
public class CommissionController {

    private final CommissionService commissionService;
    private final UserService userService;

    public CommissionController(CommissionService commissionService, UserService userService) {
        this.commissionService = commissionService;
        this.userService = userService;
    }

    @PostMapping("/calculate/{userId}")
    public ResponseEntity<Commission> calculateCommission(@PathVariable Long userId,
                                                         @RequestParam double amount,
                                                         @RequestParam int level) {
        User user = userService.getUserById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Commission commission = commissionService.calculateCommission(user, amount, level);
        return ResponseEntity.ok(commission);
    }
}