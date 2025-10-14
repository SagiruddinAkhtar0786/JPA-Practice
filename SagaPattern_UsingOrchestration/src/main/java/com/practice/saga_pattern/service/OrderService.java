package com.practice.saga_pattern.service;

import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.Order;
import jakarta.transaction.Transactional;

@Service
public class OrderService {
    private final OrderRepository orderRepo;

    public OrderService(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Transactional
    public Long createOrder(Long userId, Double amount) {
        Order order = new Order();
        order.setUserId(userId);
        order.setAmount(amount);
        orderRepo.save(order);
        System.out.println("✅ Order created");
        return order.getId();
    }

    @Transactional
    public void cancelOrder(Long orderId) {
        orderRepo.deleteById(orderId);
        System.out.println("↩️ Order cancelled (compensation)");
    }
}

