package edu.miu.cs.cs544.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.miu.cs.cs544.domain.User;


public interface UserService {
	public String createUser(User user);
	public String updateUser(int id, User user);
	public String deleteUser(int id);
	public List<User> getAllUsers();
	public User getUserById(int id);
	public Boolean usernameExists(String username);
	public String login(String username, String password);
}
