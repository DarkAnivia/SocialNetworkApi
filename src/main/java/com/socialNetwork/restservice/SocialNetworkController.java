package com.socialNetwork.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody ;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocialNetworkController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/userList")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@PostMapping("/register")
	public Greeting registerUser(@RequestBody Greeting userId){
		return new Greeting (counter.incrementAndGet(), userId.getContent());
	}

	@PostMapping("/addFriend")
	public Greeting addFriend(@RequestBody Greeting userId){
		System.out.println(userId);
		return new Greeting (counter.incrementAndGet(), userId.getContent());
	}
	
	@PostMapping("/acceptFriend")
	public Greeting acceptFriend(@RequestBody Greeting userId){
		System.out.println(userId);
		return new Greeting (counter.incrementAndGet(), userId.getContent());
	}

	@PostMapping("/declineFriend")
	public Greeting declineFriend(@RequestBody Greeting userId){
		System.out.println(userId);
		return new Greeting (counter.incrementAndGet(), userId.getContent());
	}

}
