package com.example.graphql.query;


import com.example.entity.Portfolio;
import com.example.entity.User;
import com.example.service.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class UserQuery implements GraphQLQueryResolver {

    @Autowired
    private UserService userservice;

    public Optional<User> userById(final int id) {
        return this.userservice.getUser(id);
    }

    public List<Portfolio> portfoliosByUser(final int id) {
        return this.userservice.getUser(id).isPresent() ?
                this.userservice.getUser(id).get().getPortfolios() :
                Collections.emptyList();
    }
}
