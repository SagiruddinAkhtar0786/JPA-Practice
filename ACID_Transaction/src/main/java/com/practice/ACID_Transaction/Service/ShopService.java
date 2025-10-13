package com.practice.ACID_Transaction.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.ACID_Transaction.Entity.Account;
import com.practice.ACID_Transaction.Entity.Order;
import com.practice.ACID_Transaction.Entity.Product;
import com.practice.ACID_Transaction.Repository.AccountRepository;
import com.practice.ACID_Transaction.Repository.OrderRepository;
import com.practice.ACID_Transaction.Repository.ProductRepository;

import jakarta.transaction.Transactional;
@Service
public class ShopService {

		@Autowired
		private OrderRepository orderRepo;
		@Autowired
	    private AccountRepository accountRepo;
		@Autowired
	    private ProductRepository productRepo;
		
		
		@Transactional
		public void placeOrder(Long userId, Long productId, Double amount) {
	        // 1️⃣ Create Order
	        Order order = new Order();
	        order.setUserId(userId);
	        order.setAmount(amount);
	        orderRepo.save(order);
	        System.out.println("✅ Order created.");

	        // 2️⃣ Process Payment
	        Account account = accountRepo.findById(userId)
	                .orElseThrow(() -> new RuntimeException("Account not found"));
	        if (account.getBalance() < amount) throw new RuntimeException("Insufficient balance");
	        account.setBalance(account.getBalance() - amount);
	        accountRepo.save(account);
	        System.out.println("💳 Payment processed.");

	        // 3️⃣ Reduce Stock
	        Product product = productRepo.findById(productId)
	                .orElseThrow(() -> new RuntimeException("Product not found"));
	        if (product.getStock() <= 0) throw new RuntimeException("Product out of stock");
	        product.setStock(product.getStock() - 1);
	        productRepo.save(product);
	        System.out.println("📦 Stock reduced.");

	        System.out.println("🎉 Transaction committed successfully!");
	    }	
	
}
