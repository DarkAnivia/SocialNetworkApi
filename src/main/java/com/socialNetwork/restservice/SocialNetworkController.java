package com.socialNetwork.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody ;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SocialNetworkController {

    @Autowired
	SocialNetworkService socialNetworkService;
	

	// @GetMapping("/userList")
	// public User greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
	// 	return new User (userId.getName(), userId.getPwd());
	// }
	

	@PostMapping("/register")
	public User registerUser(@RequestBody User user){

		socialNetworkService.register(user);
		return new User (user.getName(), user.getPwd());
	}

	// @PostMapping("/addFriend")
	// public User addFriend(@RequestBody Greeting userId){
	// 	System.out.println(userId);
	// 	return new User (counter.incrementAndGet(), userId.getContent());
	// }
	
	// @PostMapping("/acceptFriend")
	// public User acceptFriend(@RequestBody User userId){
	// 	System.out.println(userId);
	// 	return new User (counter.incrementAndGet(), userId.getContent());
	// }

	// @PostMapping("/declineFriend")
	// public Greeting declineFriend(@RequestBody Greeting userId){
	// 	System.out.println(userId);
	// 	return new Greeting (counter.incrementAndGet(), userId.getContent());
	// }

}
