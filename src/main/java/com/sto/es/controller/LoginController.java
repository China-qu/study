package com.sto.es.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping("/")
	public String login() {
		return "/index.html";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "/index.html";
	}
	
}
