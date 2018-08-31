/**
 * 
 */
package com.kt.spring.demo.springdemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.kt.spring.demo.springdemo.entity.Account;


/**
 * @author karna
 * Test
 */
public interface AccountRepository extends CrudRepository<Account, Long> {

	Account findByUsername(String username);
	Account findByUsernameAndPassword(String username, String password);
	
}
