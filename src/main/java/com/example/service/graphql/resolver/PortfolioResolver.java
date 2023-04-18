package com.example.service.graphql.resolver;

import com.example.dao.entity.Portfolio;
import com.example.model.PortfolioDto;
import com.example.model.StockDto;
import com.example.model.UserDto;
import com.example.service.StockService;
import com.example.service.UserService;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PortfolioResolver implements GraphQLResolver<Portfolio> {

    private final UserService userService;
    private final StockService stockService;

    public UserDto user(PortfolioDto portfolio) {
        return userService.findByName(portfolio.getUser().getName());
    }

    public StockDto stock(PortfolioDto portfolio) {
        return stockService.findByName(portfolio.getStock().getName());
    }
}
