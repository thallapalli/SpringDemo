package com.kt.spring.demo.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kt.spring.demo.springdemo.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
