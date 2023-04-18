package com.example.service.graphql.mutation;

import com.example.model.UserDto;
import com.example.service.UserService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMutation implements GraphQLMutationResolver {

    private final UserService userService;

    public UserDto createUser(String name) {
        return userService.create(name);
    }
}
