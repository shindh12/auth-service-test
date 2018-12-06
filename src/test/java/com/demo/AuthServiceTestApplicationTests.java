package com.demo;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.model.Role;
import com.demo.model.Writer;
import com.demo.repo.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthServiceTestApplicationTests {
	
	@Autowired
	UserRepository repo;
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void Test() {
		repo.save(new Writer("hey","hey",Arrays.asList(new Role("USER")),"타입"));
	}
}
