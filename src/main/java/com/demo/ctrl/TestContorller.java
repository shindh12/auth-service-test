package com.demo.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContorller {
	@GetMapping("/")
	public String index() {
		return "hello";
	}
	
	@GetMapping("/private")
	public String privateArea() {
		return "private";
	}
}
