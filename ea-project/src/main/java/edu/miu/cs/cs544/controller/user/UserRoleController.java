package edu.miu.cs.cs544.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.cs544.domain.user.UserRole;
import edu.miu.cs.cs544.service.user.UserRoleService;

@RestController
@RequestMapping("/userroles")
public class UserRoleController {
	@Autowired
	private UserRoleService userRoleService;
	
	@PostMapping(value = "createrole")
	public void saveUser(UserRole role) {
		try {
			userRoleService.createUserRole(role);;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@GetMapping(value="all")
	public List<UserRole> getAllUserRoles(){
		try {
			return userRoleService.getAllUserRoles();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
