package com.library.demo.service;

import com.library.demo.entity.User;

import java.util.List;


public interface UserService {
    User findByUsername(String username);
    User findById(Long id);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    List<User> getAllUsers();
    User login(String username, String password);


}
