package com.example.service.graphql.query;

import com.example.model.UserDto;
import com.example.service.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserQuery implements GraphQLQueryResolver {

    private final UserService userservice;

    public UserDto findUser(String name) {
        return userservice.findByName(name);
    }
}
