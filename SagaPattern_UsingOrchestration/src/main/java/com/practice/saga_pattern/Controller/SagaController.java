package com.practice.saga_pattern.Controller;

//package com.practice.ACID_Transaction.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.saga_pattern.service.SagaOrchestrator;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/saga")
@RequiredArgsConstructor
public class SagaController {

    private final SagaOrchestrator sagaOrchestrator;

    @PostMapping("/placeOrder")
    public String placeOrder(
            @RequestParam Long userId,
            @RequestParam Long productId,
            @RequestParam Double amount) {

        try {
            sagaOrchestrator.placeOrderSaga(userId, productId, amount);
            return "✅ Order placed successfully via Saga pattern!";
        } catch (Exception e) {
            return "❌ Failed to place order: " + e.getMessage();
        }
    }
}
