package edu.miu.cs.cs544.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.miu.cs.cs544.domain.UserRole;

public interface UserRoleService {
	public String createUserRole(UserRole userrole);
	public List<UserRole> getAllUserRoles();
	public UserRole getUserRoleById(int id);
}
