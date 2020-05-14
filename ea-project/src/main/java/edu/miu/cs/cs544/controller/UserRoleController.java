package edu.miu.cs.cs544.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.domain.Appointment;
import edu.miu.cs.cs544.domain.User;
import edu.miu.cs.cs544.domain.UserRole;
import edu.miu.cs.cs544.service.UserRoleService;

@RestController
@RequestMapping("/userroles")
public class UserRoleController {
	@Autowired
	private UserRoleService userRoleService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createUserRole(@RequestBody UserRole userrole) {
		try {

			String result = userRoleService.createUserRole(userrole);
			return ResponseEntity.ok().body(result);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
		}
	}

	@GetMapping
	public ResponseEntity getAllUserRoles() {
		try {
			List<UserRole> roles = userRoleService.getAllUserRoles();
			return ResponseEntity.status(HttpStatus.OK).body(roles);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity getUserRoleById(@PathVariable int id) {
		try {
			UserRole role = userRoleService.getUserRoleById(id);

			return ResponseEntity.status(HttpStatus.OK).body(role);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
