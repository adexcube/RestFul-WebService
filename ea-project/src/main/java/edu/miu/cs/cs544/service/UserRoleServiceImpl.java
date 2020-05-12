package edu.miu.cs.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs.cs544.domain.UserRole;
import edu.miu.cs.cs544.repository.UserRoleRepository;


@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Override
	public void createUserRole(UserRole userRole) {
		userRoleRepository.save(userRole);
	}

	@Override
	public List<UserRole> getAllUserRoles() {
		return userRoleRepository.findAll();
	}

	@Override
	public UserRole getUserRoleById(int id) {
		return userRoleRepository.findById(id).orElse(null);
	}

}
