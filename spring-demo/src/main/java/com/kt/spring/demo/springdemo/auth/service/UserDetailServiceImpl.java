/**
 * 
 */
package com.kt.spring.demo.springdemo.auth.service;

import java.util.HashSet;
import java.util.Set;


import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kt.spring.demo.springdemo.entity.Account;
import com.kt.spring.demo.springdemo.entity.Role;
import com.kt.spring.demo.springdemo.repository.AccountRepository;

/**
 * @author karna
 *
 */

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	Logger logger = LoggerFactory.getLogger(UserDetailServiceImpl.class);
	@Autowired
	AccountRepository accountRepository;

	/**
	 * 
	 */
	public UserDetailServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Account account = accountRepository.findByUsername(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for(Role role:account.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new User(username,account.getPassword(),grantedAuthorities);
		
		
	}

}
