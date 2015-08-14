package com.ran.sample.spring.controller;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ran.sample.spring.vo.Greeting;

@RestController
@RequestMapping("/healthCheck")
public class HealthCheck {
		//Return simple String	
		@RequestMapping(value = "/default", method = RequestMethod.GET)
		public String hello() {
		
			return "I am fine";
			
		}		
				
		@RequestMapping(value = "/greet/{msg}", method = RequestMethod.GET)
		public @ResponseBody Greeting displayMessage(@PathVariable String msg) {			
			return new Greeting(1, msg + "!") ;
		}
	}