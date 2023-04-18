package com.example.service;

import com.example.dao.repository.UserRepository;
import com.example.dao.entity.User;
import com.example.model.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final MapperFacade mapperFacade;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDto create(String name) {
        log.info("Creating User with name {}", name);
        var user = userRepository.save(User.builder()
                .name(name)
                .build());
        return mapperFacade.map(user, UserDto.class);
    }

    @Override
    public UserDto findByName(String userName) {
        log.info("Searching user by name: {}", userName);
        return mapperFacade.map(this.findUserByName(userName), UserDto.class);
    }

    @Override
    public User findUserByName(String userName) {
        log.info("Searching user by name: {}", userName);
        return userRepository.findByName(userName)
                .orElseThrow(() -> new RuntimeException(String.format("No user found with such name: %s", userName)));
    }
}
