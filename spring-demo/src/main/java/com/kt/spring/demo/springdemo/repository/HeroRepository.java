/**
 * 
 */
package com.kt.spring.demo.springdemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.kt.spring.demo.springdemo.entity.Account;
import com.kt.spring.demo.springdemo.entity.Hero;


/**
 * @author karna
 * Test
 */
public interface HeroRepository extends CrudRepository<Hero, Long> {

	
	
}
