package com.ran.sample.spring.controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthCheck")
public class HealthCheck {

		@RequestMapping(value = "/default", method = RequestMethod.GET)
		public String hello(ModelMap model) {			
			return "I am fine";
		}				
	}