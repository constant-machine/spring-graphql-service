package com.example.service.graphql.mutation;

import com.example.model.PortfolioDto;
import com.example.service.PortfolioService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PortfolioMutation implements GraphQLMutationResolver {

    private final PortfolioService portfolioService;

    public PortfolioDto createPortfolio(String userName, String stockName, int quantity) {
        return portfolioService.createPortfolio(userName, stockName, quantity);
    }
}
