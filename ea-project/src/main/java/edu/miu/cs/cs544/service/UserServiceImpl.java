package edu.miu.cs.cs544.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.miu.cs.cs544.domain.User;
import edu.miu.cs.cs544.domain.UserRole;
import edu.miu.cs.cs544.repository.UserRepository;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public String createUser(User user) {
		if (!usernameExists(user.getUsername())) {
			
			for (UserRole role : user.getRoles()) {
				role.setUser(user);
			}
			userRepository.save(user);

			return "User created Successfully";
		}

		return "Username already Exists";
	}

	@Override
	public String updateUser(int id, User user) {
		user.setId(id);
		userRepository.save(user);
		return "User updated Successfully";
	}

	@Override
	public String deleteUser(int id) {
		userRepository.deleteById(id);
		return "User deleted Successfully";

	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public Boolean usernameExists(String username) {
		int count = (int) userRepository.findAll().stream().filter(u -> u.getUsername().equals(username)).count();
		return count > 0;
	}

	@Override
	public String login(String username, String password) {
		Optional<User> user = userRepository.findAll().stream()
				.filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password)).findFirst();

		if (user != null)
			return "User logged in Successfully";

		return "Invalid Credentails";
	}

}
