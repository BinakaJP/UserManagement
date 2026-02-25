package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.data.metrics.MetricsRepositoryMethodInvocationListener;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final MetricsRepositoryMethodInvocationListener metricsRepositoryMethodInvocationListener;

    public UserService(UserRepository userRepository, MetricsRepositoryMethodInvocationListener metricsRepositoryMethodInvocationListener) {
        this.userRepository = userRepository;
        this.metricsRepositoryMethodInvocationListener = metricsRepositoryMethodInvocationListener;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id" + id));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(String id, User userDetails) {
        User user = getUserById(id);
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setAge(userDetails.getAge());
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }

    public List<User> getUsersByAgeRange(int minAge, int maxAge){
        return userRepository.findByAgeBetween(minAge, maxAge);
    }

    public List<User> searchUsersByName(String name) {
        return userRepository.findByNameContainingIgnoreCase(name);
    }
}