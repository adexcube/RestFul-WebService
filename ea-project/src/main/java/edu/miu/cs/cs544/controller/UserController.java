package edu.miu.cs.cs544.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.domain.User;
import edu.miu.cs.cs544.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public void createUser(@RequestBody User user) {
		try {
			userService.createUser(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void updateUser(@PathVariable int id, @RequestBody User user) {
		try {
			userService.updateUser(id, user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@DeleteMapping(value = "/{id}")
	public void deleteUser(@PathVariable int id) {
		try {
			userService.deleteUser(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@GetMapping
	public List<User> getAllUsers() {
		try {
			return userService.getAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping(value = "/{id}")
	public User getUserById(@PathVariable int id) {
		try {
			return userService.getUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
