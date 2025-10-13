package com.practice.ACID_Transaction.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Product {
    @Id
    private Long productId;
    private Integer stock;

    // getters and setters
}

