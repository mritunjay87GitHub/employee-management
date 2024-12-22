package com.mks.service.impl;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mks.entity.Employee;
import com.mks.service.intf.EmployeeService;

@Service
public class EmsUserDetailsServiceImpl implements UserDetailsService {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmsUserDetailsServiceImpl.class);

	@Autowired
	private EmployeeService employeeService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LOGGER.info("Entry to EmsUserDetailsServiceImpl >>> loadUserByUsername() method ==>{}",username);
		try {
			Employee employee = employeeService.findByUserName(username);
			LOGGER.info("Employee Info EmsUserDetailsServiceImpl >>> loadUserByUsername() method ==>{}");
			if (employee == null) {
				LOGGER.warn("user not found: {}", username);
	            throw new UsernameNotFoundException("User " + username + " not found");
	        }
			final List<SimpleGrantedAuthority> roles = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
			
			return new User(employee.getUserName(), employee.getPassword(),roles);
			//return new User(employee.getUserName(), employee.getPassword(), false, false, false, false, roles);
			
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
		}
		LOGGER.info("Exit from EmsUserDetailsServiceImpl >>> loadUserByUsername() method");
		return null;
	}
}
