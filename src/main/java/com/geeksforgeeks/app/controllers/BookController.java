package com.geeksforgeeks.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/book")
public class BookController {
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/port")
	public String getPort() {
		return environment.getProperty("local.server.port");
	}
}