package com.practice.saga_pattern.service;

import org.springframework.stereotype.Service;

import com.practice.saga_pattern.entities.Account;
import com.practice.saga_pattern.repository.AccountRepository;

import jakarta.transaction.Transactional;

@Service
public class PaymentService {
    private final AccountRepository accountRepo;

    public PaymentService(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Transactional
    public void processPayment(Long userId, Double amount) {
        Account account = accountRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getBalance() < amount) throw new RuntimeException("Insufficient balance");
        account.setBalance(account.getBalance() - amount);
        accountRepo.save(account);
        System.out.println("💳 Payment processed");
    }

    @Transactional
    public void refundPayment(Long userId, Double amount) {
        Account account = accountRepo.findById(userId).orElseThrow();
        account.setBalance(account.getBalance() + amount);
        accountRepo.save(account);
        System.out.println("↩️ Payment refunded (compensation)");
    }
}

