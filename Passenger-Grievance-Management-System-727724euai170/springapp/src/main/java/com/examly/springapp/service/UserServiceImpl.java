package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    public User addUser(User user) {
        return repo.save(user);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getUserById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public User updateUser(Long id, User user) {
        User u = repo.findById(id).orElse(null);
        if (u == null) return null;
        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());
        u.setRole(user.getRole());
        if (user.getPhoneNumber() != null) {
            u.setPhoneNumber(user.getPhoneNumber());
        }
        return repo.save(u);
    }
}
