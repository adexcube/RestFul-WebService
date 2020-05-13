package edu.miu.cs.cs544.service;


import edu.miu.cs.cs544.domain.User;

public interface LoginService {
    public User login(String username, String password);
}
