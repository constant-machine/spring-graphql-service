package com.example.service;

import com.example.dao.entity.User;
import com.example.model.UserDto;

public interface UserService {
    UserDto create(String name);
    UserDto findByName(String userName);
    User findUserByName(String userName);
}
