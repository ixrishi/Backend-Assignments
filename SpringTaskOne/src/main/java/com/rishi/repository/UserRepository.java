package com.rishi.repository;

import com.rishi.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {

    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        addUser(new User(1, "rishi", "rishi@gmail.com","Hyderabad"));
        addUser(new User(2, "rahul", "rahul@gmail.com","Delhi"));
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    public Optional<User> findById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    public Optional<User> addUser(User user) {
        users.add(user);
        return findById(user.getId());
    }
}