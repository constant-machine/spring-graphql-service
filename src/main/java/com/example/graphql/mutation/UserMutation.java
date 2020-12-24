package com.example.graphql.mutation;

import com.example.entity.User;
import com.example.service.UserService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMutation implements GraphQLMutationResolver {

    @Autowired
    private UserService userService;

    public User createUser(final String name) {
        return userService.create(name);
    }
}
