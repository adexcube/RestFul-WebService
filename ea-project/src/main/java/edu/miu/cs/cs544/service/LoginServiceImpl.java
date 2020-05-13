package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.User;
import edu.miu.cs.cs544.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String username, String password) {
        Optional<User> user = userRepository.findAll().stream().filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password)).findFirst();
        return user.orElse(null);
    }
}
