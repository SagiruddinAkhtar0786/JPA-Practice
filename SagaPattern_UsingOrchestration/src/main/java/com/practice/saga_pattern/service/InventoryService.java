package com.practice.saga_pattern.service;

import org.springframework.stereotype.Service;

import com.practice.saga_pattern.entities.Product;

import jakarta.transaction.Transactional;

@Service
public class InventoryService {
    private final ProductRepository productRepo;

    public InventoryService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @Transactional
    public void reduceStock(Long productId) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        if (product.getStock() <= 0) throw new RuntimeException("Out of stock");
        product.setStock(product.getStock() - 1);
        productRepo.save(product);
        System.out.println("📦 Stock reduced");
    }

    @Transactional
    public void addStock(Long productId) {
        Product product = productRepo.findById(productId).orElseThrow();
        product.setStock(product.getStock() + 1);
        productRepo.save(product);
        System.out.println("↩️ Stock restored (compensation)");
    }
}

