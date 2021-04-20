package com.example.service;

import com.example.repository.UserRepository;
import com.example.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User create(final String name) {
        log.info("Creating User with name {}", name);
        final User user = new User();
        user.setName(name);
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(final int id) {
        log.info("Searching user by id: {}", id);
        return userRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<User> find(User user) {
        log.info("Searching User: {}", user.getId());
        return userRepository.findById(user.getId());
    }
}
