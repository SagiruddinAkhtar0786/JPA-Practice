package com.practice.saga_pattern.service;

import org.springframework.stereotype.Service;

@Service
public class SagaOrchestrator {

    private final OrderService orderService;
    private final PaymentService paymentService;
    private final InventoryService inventoryService;

    public SagaOrchestrator(OrderService orderService, PaymentService paymentService, InventoryService inventoryService) {
        this.orderService = orderService;
        this.paymentService = paymentService;
        this.inventoryService = inventoryService;
    }

    public void placeOrderSaga(Long userId, Long productId, Double amount) {
        Long orderId = null;
        try {
            // Step 1: Create order
            orderId = orderService.createOrder(userId, amount);

            // Step 2: Process payment
            paymentService.processPayment(userId, amount);

            // Step 3: Reduce stock
            inventoryService.reduceStock(productId);

            System.out.println("🎉 Saga completed successfully!");

        } catch (Exception e) {
            System.out.println("❌ Saga failed: " + e.getMessage());
            // Compensate previous steps
            if (orderId != null) orderService.cancelOrder(orderId);
            paymentService.refundPayment(userId, amount);
            inventoryService.addStock(productId);
        }
    }
}
