package com.BiblioSpring.security;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.BiblioSpring.entity.User;
import com.BiblioSpring.repository.UserRepository;

@Component
public class DatabaseUsersLoader {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	private void initDatabase() {

		userRepository.save(new User("user", "pass","chengjianli17972gmail.com","ROLE_USER"));
		userRepository.save(new User("admin", "adminpass", "chengjian_li@gamil.com","ROLE_USER", "ROLE_ADMIN"));
	}

}