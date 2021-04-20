package com.example;

import com.example.entity.User;
import com.example.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class UserServiceTest {

    @Autowired
    private UserService userService;
    private static final String userName = "Harry";

    @Test
    public void userServiceTest() {
        User user = userService.create(userName);
        Assertions.assertEquals(userName, user.getName());
        Assertions.assertFalse(userService.find(user).isEmpty());
        Assertions.assertEquals(userName, userService.find(user).get().getName());
        Assertions.assertEquals(user.getId(), userService.find(user).get().getId());
    }
}
