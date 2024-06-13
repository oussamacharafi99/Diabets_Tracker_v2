package com.Diabetes.Service.UserService;
import com.Diabetes.Models.Users.User;
import com.Diabetes.Repository.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(Math.toIntExact(id));
        return user.orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }
}
