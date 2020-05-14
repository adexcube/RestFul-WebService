package edu.miu.cs.cs544.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.domain.User;
import edu.miu.cs.cs544.domain.UserRole;
import edu.miu.cs.cs544.service.Response;
import edu.miu.cs.cs544.service.UserRoleService;
import edu.miu.cs.cs544.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserRoleService userRoleService;

	@PostMapping(value="/new", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createUser(@RequestBody User user) {
		try {
			String result = userService.createUser(user);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateUser(@PathVariable int id, @RequestBody User user) {
		try {
			String result = userService.updateUser(id, user);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity deleteUser(@PathVariable int id) {
		try {
			String result = userService.deleteUser(id);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity getAllUsers() {
		try {
			List<User> result = userService.getAllUsers();
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity getUserById(@PathVariable int id) {
		try {
			User user = userService.getUserById(id);
			return ResponseEntity.status(HttpStatus.OK).body(user);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

	}
}
