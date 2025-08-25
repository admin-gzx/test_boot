package com.library.demo.service.impl;
import org.springframework.stereotype.Service;
import com.library.demo.entity.User;

import com.library.demo.repository.UserRepository;

import com.library.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);

    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = null;
        
        // 如果ID为null，表示创建新用户
        if (id == null) {
            return userRepository.save(user);
        }
        
        // 如果ID不为null，表示更新现有用户
        existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            // 更新用户信息
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhone(user.getPhone());
            existingUser.setAddress(user.getAddress());
            return userRepository.save(existingUser);
        }
        return null;
    }
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();

    }


    @Override
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

 

}
