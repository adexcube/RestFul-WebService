package edu.miu.cs.cs544.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.miu.cs.cs544.domain.UserRole;

public interface UserRoleService {
	public List<UserRole> getAllUserRoles();
	public UserRole getUserRoleById(int id);
	public List<String> getUserRolesByUserId(int userid);
}
