package edu.miu.cs.cs544.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.domain.User;
import edu.miu.cs.cs544.service.Response;
import edu.miu.cs.cs544.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "createuser", produces = MediaType.APPLICATION_JSON_VALUE)
//	public Response createUser(@RequestBody User user) {
//		public void createUser(User user) {	
//			try {
//			userService.createUser(user);
//		}catch(Exception e) {
//			return new Response(400, e.getMessage(), null);
//		}
//		return new Response(200, "succeed", null);
//	}
	public void saveUser(User user) {
		try {
			userService.createUser(user);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@GetMapping(value="all")
	public List<User> getAllUsers(){
		try {
			return userService.getAllUsers();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
