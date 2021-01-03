package com.example.graphql.query;

import com.example.entity.User;
import com.example.service.PortfolioService;
import com.example.service.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserQuery implements GraphQLQueryResolver {

    @Autowired
    private UserService userservice;

    @Autowired
    private PortfolioService portfolioService;

    public Optional<User> userById(final int id) {
        return this.userservice.findById(id);
    }
}
