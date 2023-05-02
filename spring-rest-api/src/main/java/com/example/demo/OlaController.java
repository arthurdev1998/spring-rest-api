package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OlaController {
	private static final String template = "hello, %s";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/hello")
	public olamarilene olamarilene(@RequestParam(value="name",defaultValue = "world")String name) {
		return new olamarilene(counter.incrementAndGet(),String.format(template, name));
	}
	
}
