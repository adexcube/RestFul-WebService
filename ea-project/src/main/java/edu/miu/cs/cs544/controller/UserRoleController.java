package edu.miu.cs.cs544.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.domain.UserRole;
import edu.miu.cs.cs544.service.Response;
import edu.miu.cs.cs544.service.UserRoleService;

@RestController
@RequestMapping("/userroles")
public class UserRoleController {
	@Autowired
	private UserRoleService userRoleService;

	@GetMapping
	public Response getAllUserRoles() {
		try {
			List<UserRole> roles = userRoleService.getAllUserRoles();
			return new Response(200, "successful", roles);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(400, e.getMessage());
		}

	}

	@GetMapping(value = "/{id}")
	public Response getUserRoleById(@PathVariable int id) {
		try {
			UserRole role = userRoleService.getUserRoleById(id);
			return new Response(200, "successful", role);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(400, e.getMessage());
		}
	}

	@GetMapping(value = "user/{userid}")
	public Response getUserRolesByUserId(@PathVariable int userid) {
		try {
			List<String> roles = userRoleService.getUserRolesByUserId(userid);
			return new Response(200, "successful", roles);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(400, e.getMessage());
		}
	}
}
