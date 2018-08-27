/**
 * 
 */
package com.kt.spring.demo.springdemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.kt.spring.demo.springdemo.entity.Department;

/**
 * @author karna
 *
 */
public interface DepartmentRepository extends CrudRepository<Department, Long> {

	
	
}
