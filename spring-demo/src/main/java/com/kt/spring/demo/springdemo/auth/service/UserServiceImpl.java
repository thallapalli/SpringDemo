package com.kt.spring.demo.springdemo.auth.service;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kt.spring.demo.springdemo.entity.Account;
import com.kt.spring.demo.springdemo.repository.AccountRepository;
import com.kt.spring.demo.springdemo.repository.RoleRepository;

@Service

public class UserServiceImpl implements UserService {

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;
   
    @Override
    public void save(Account account) {
    	account.setPassword(account.getPassword());
    	account.setRoles(new ArrayList(roleRepository.findAll()));
    	accountRepository.save(account);
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

}
