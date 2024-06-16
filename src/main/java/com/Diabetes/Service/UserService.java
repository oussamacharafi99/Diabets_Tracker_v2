package com.Diabetes.Service;

import com.Diabetes.Models.Users.User;
import com.Diabetes.Repository.UserRepository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }
    @Transactional

    public void updateUser(User user) {
        userRepository.save(user);
    }
    @Transactional

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id.intValue());
        return user.orElse(null);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id.intValue());
    }

}
