package com.demo;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import com.demo.model.Role;
import com.demo.model.User;
import com.demo.model.Writer;
import com.demo.repo.UserRepository;

@SpringBootApplication
//@EnableAuthorizationServer
public class AuthServiceTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceTestApplication.class, args);
	}

//	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repo) throws Exception {
//		builder.userDetailsService(new UserDetailsService() {
//			@Override
//			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//				return new CustomUserDetails(repo.findByUsername(username));
//			}
//		});
		if(repo.count() == 0) {
			repo.save(new User("user","user",Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));
		}
		builder.userDetailsService(username -> new CustomUserDetails(repo.findByUsername(username)));
	}
}
