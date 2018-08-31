package com.kt.spring.demo.springdemo.auth.service;

public interface SecurityService {
	 public String findLoggedInUsername() ;
	 public void autologin(String username, String password) ;

}
