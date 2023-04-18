package com.example.service.graphql.query;

import com.example.model.PortfolioDto;
import com.example.service.PortfolioService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PortfolioQuery implements GraphQLQueryResolver {

    private final PortfolioService portfolioService;

    public List<PortfolioDto> portfoliosByUser(String name) {
        return portfolioService.getByUserName(name);
    }
}
