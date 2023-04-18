package com.example;

import com.example.dao.entity.User;
import com.example.model.UserDto;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class UserServiceTest {

    @Autowired
    private UserService userService;
    private static final String userName = "Harry";

    @Test
    public void userServiceTest() {
        UserDto user = userService.create(userName);
        assertEquals(userName, user.getName());
        User userFound = userService.findUserByName(user.getName());
        assertNotNull(userFound);
        assertEquals(userName, userFound.getName());
    }
}
