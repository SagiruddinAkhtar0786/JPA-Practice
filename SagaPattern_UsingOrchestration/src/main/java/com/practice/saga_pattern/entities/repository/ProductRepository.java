/**
 * 
 */
package com.practice.saga_pattern.entities.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.saga_pattern.entities.Product;

/**
 * 
 */
public interface ProductRepository extends JpaRepository<Product,Long>{

}
