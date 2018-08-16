package com.cg.mmbspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MMBController {
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}

}
