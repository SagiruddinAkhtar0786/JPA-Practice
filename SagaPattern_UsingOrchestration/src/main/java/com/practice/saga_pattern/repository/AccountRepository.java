/**
 * 
 */
package com.practice.saga_pattern.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.saga_pattern.entities.Account;

/**
 * 
 */
public interface AccountRepository extends JpaRepository<Account,Long>{

}
