package edu.miu.cs.cs544.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.domain.User;
import edu.miu.cs.cs544.service.Response;
import edu.miu.cs.cs544.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Response createUser(@RequestBody User user) {
		try {
			String result = userService.createUser(user);
			return new Response(200, result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new Response(400, e.getMessage());
		}
	}

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Response updateUser(@PathVariable int id, @RequestBody User user) {
		try {
			String result = userService.updateUser(id, user);
			return new Response(200, result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new Response(400, e.getMessage());
		}
	}

	@DeleteMapping(value = "/{id}")
	public Response deleteUser(@PathVariable int id) {
		try {
			String result = userService.deleteUser(id);
			return new Response(200, result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new Response(400, e.getMessage());
		}
	}

	@GetMapping
	public Response getAllUsers() {
		try {
			List<User> result = userService.getAllUsers();
			return new Response(200, "successful", result);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(400, e.getMessage());
		}

	}

	@GetMapping(value = "/{id}")
	public Response getUserById(@PathVariable int id) {
		try {
			User user = userService.getUserById(id);
			return new Response(200, "successful", user);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(400, e.getMessage());
		}

	}

	@GetMapping(value = "/login")
	public Response login(@RequestBody User user) {
		try {
			String result = userService.login(user.getUsername(), user.getPassword());
			return new Response(200, result);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(400, e.getMessage());
		}

	}
}
