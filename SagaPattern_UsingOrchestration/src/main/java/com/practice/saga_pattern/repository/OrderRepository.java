/**
 * 
 */
package com.practice.saga_pattern.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.saga_pattern.entities.Order;

//import jakarta.persistence.criteria.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
