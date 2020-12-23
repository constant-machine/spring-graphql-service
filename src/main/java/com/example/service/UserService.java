package com.example.service;

import com.example.repository.UserRepository;
import com.example.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User createUser(final String name) {
        final User user = new User();
        user.setName(name);
        return this.userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public Optional<User> getUser(final int id) {
        return this.userRepository.findById(id);
    }
}
