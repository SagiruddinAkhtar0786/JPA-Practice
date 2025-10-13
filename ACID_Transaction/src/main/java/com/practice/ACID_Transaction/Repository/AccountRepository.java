/**
 * 
 */
package com.practice.ACID_Transaction.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.ACID_Transaction.Entity.Account;

/**
 * 
 */
public interface AccountRepository extends JpaRepository<Account,Long>{

}
