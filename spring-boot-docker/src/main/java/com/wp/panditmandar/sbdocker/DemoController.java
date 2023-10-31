package com.wp.panditmandar.sbdocker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/hello/{name}")
	public String greetings(@PathVariable(name = "name") String name) {
		return "Hello " + name + " !";
	}
}
