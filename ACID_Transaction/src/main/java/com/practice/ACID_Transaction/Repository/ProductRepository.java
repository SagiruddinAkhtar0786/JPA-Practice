/**
 * 
 */
package com.practice.ACID_Transaction.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.ACID_Transaction.Entity.Product;

/**
 * 
 */
public interface ProductRepository extends JpaRepository<Product,Long>{

}
