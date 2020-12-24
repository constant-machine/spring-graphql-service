package com.example.graphql.query;

import com.example.entity.Portfolio;
import com.example.service.PortfolioService;
import com.example.service.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PortfolioQuery implements GraphQLQueryResolver {

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private UserService userService;

    public Optional<Portfolio> portfolioById(final int id) {
        return this.portfolioService.findPortfolio(id);
    }

    public List<Portfolio> portfoliosByUser(final int id) {
        return this.portfolioService.getByUserId(id);
    }
}
