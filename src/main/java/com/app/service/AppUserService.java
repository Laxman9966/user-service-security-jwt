package com.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.auth.model.PocUser;
import com.app.auth.repository.UserRepository;

@Service
public class AppUserService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	private String name;
	private Long sid;
	
	public UserDetails loadUserByUsernameUserType(String username, String usertype ) throws UsernameNotFoundException {
		PocUser user = userRepository.findByUserNameUserType(username, usertype);
		this.sid = user.getId();
		this.name = user.getName();
		if (user != null) 
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					new ArrayList<>());
		throw new UsernameNotFoundException(" ******$$$$$  User not found with username: " + username);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username ) throws UsernameNotFoundException {
		PocUser user = userRepository.findByUserName(username);
		if (user != null) 
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					new ArrayList<>());
		throw new UsernameNotFoundException(" ******$$$$$  User not found with username: " + username);
	}
	
	public PocUser saveUser(PocUser user) {
		PocUser newUser = new PocUser();
		newUser.setName(user.getName());
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setUsertype(user.getUsertype());
		return userRepository.save(newUser);
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
