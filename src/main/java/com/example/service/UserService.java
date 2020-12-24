package com.example.service;

import com.example.repository.UserRepository;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User create(final String name) {
        final User user = new User();
        user.setName(name);
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(final int id) {
        return userRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<User> find(User user) {
        return userRepository.findById(user.getId());
    }
}
