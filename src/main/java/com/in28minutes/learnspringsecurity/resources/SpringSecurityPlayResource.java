package com.in28minutes.learnspringsecurity.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityPlayResource {

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello - Christ is Lord and King - given all authority in Heaven and Earth";
	}
}
