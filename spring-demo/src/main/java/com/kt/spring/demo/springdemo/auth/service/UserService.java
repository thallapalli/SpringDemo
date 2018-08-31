package com.kt.spring.demo.springdemo.auth.service;

import com.kt.spring.demo.springdemo.entity.Account;

public interface UserService {
	 public void save(Account account) ;
	 public Account findByUsername(String username) ;

}
