package com.example.graphql.mutation;

import com.example.entity.Portfolio;
import com.example.service.PortfolioService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PortfolioMutation implements GraphQLMutationResolver {

    @Autowired
    private PortfolioService portfolioService;

    public Portfolio createPortfolio(final int userId, final int stockId, final int quantity) {
        return portfolioService.createPortfolio(userId, stockId, quantity);
    }
}
