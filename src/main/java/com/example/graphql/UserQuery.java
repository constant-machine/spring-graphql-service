package com.example.graphql;


import com.example.entity.User;
import com.example.service.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserQuery implements GraphQLQueryResolver {

    @Autowired
    private UserService userservice;

    public Optional<User> userById(final int id) {
        return this.userservice.getUser(id);
    }
}
