/**
 * 
 */
package com.practice.ACID_Transaction.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.ACID_Transaction.Entity.Order;

/**
 * 
 */
public interface OrderRepository extends JpaRepository<Order,Long> {

}
