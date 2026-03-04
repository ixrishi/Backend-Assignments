package com.rishi.service;



import com.rishi.model.User;
import com.rishi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUser(int id) {
        return repository.findById(id);
    }

    public Optional<User> createUser(int id,String username, String email,String city) {
        User user = new User(id, username, email,city);
        return repository.addUser(user);
    }
}