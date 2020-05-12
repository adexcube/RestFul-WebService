package edu.miu.cs.cs544.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.domain.UserRole;
import edu.miu.cs.cs544.service.UserRoleService;

@RestController
@RequestMapping("/userroles")
public class UserRoleController {
	@Autowired
	private UserRoleService userRoleService;

	@GetMapping(value = "all")
	public List<UserRole> getAllUserRoles() {
		try {
			return userRoleService.getAllUserRoles();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping(value = "/{id}")
	public UserRole getUserRoleById(@PathVariable int id) {
		try {
			return userRoleService.getUserRoleById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping(value = "user/{userid}")
	public List<UserRole> getUserRolesByUserId(@PathVariable int userid) {
		try {
			return userRoleService.getUserRolesByUserId(userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
