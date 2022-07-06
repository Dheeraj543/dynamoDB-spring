package com.dynamodb.emp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class defaultController {
	@GetMapping
	public int getInt() {
		return 1;
	}
	@PostMapping
	public int postInt() {
		return 1;
	}
	
}
