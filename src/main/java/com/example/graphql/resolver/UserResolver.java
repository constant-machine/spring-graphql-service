package com.example.graphql.resolver;

import com.example.entity.Portfolio;
import com.example.entity.User;
import com.example.service.PortfolioService;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserResolver implements GraphQLResolver<User> {

    @Autowired
    private PortfolioService portfolioService;

    public List<Portfolio> portfolios(final User user) {
        return portfolioService.getByUser(user);
    }
}
