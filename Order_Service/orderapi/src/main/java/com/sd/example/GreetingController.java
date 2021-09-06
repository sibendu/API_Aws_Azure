package com.sd.example;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;
import com.sd.example.model.Greeting;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping(value="/greeting", produces = "application/json")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		System.out.println("I reached here");
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@PostMapping(value="/greeting", produces = "application/json")
	public Greeting greeting(@RequestBody Greeting g) {
		g.setId(1001);
		g.setContent("Created: "+g.getContent());
		return g;
	}
}
