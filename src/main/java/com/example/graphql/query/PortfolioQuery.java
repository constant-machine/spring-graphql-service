package com.example.graphql.query;

import com.example.entity.Portfolio;
import com.example.service.PortfolioService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PortfolioQuery implements GraphQLQueryResolver {

    @Autowired
    private PortfolioService portfolioService;

    public Optional<Portfolio> portfolioById(final int id) {
        return this.portfolioService.getPortfolio(id);
    }
}
