package com.library.demo.service.Servicelmpl;

import com.library.demo.entity.User;
import com.library.demo.repository.UserRepository;
import com.library.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl  implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public User createUser(User user) {
        // 检查用户名是否已存在
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            throw new RuntimeException("用户名已存在");
        }
        return userRepository.save(user);

    }

    @Override
    public User updateUser(Long id, User user) {
        User u=userRepository.findById(id).orElse(null);
        if(u!=null){
            // 将传入的用户信息更新到查询到的用户对象上
            u.setUsername(user.getUsername());
            u.setPassword(user.getPassword());
            u.setEmail(user.getEmail());
            u.setPhone(user.getPhone());
            u.setAddress(user.getAddress());
            return userRepository.save(u);
        }
        else return null;
        
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
