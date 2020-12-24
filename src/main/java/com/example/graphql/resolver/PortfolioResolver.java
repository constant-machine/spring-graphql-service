package com.example.graphql.resolver;

import com.example.entity.Portfolio;
import com.example.entity.Stock;
import com.example.entity.User;
import com.example.service.StockService;
import com.example.service.UserService;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PortfolioResolver implements GraphQLResolver<Portfolio> {

    @Autowired
    UserService userService;

    @Autowired
    StockService stockService;

    public Optional<User> user(Portfolio portfolio) {
        return userService.find(portfolio.getUser());
    }

    public Optional<Stock> stock(Portfolio portfolio) {
        return stockService.find(portfolio.getStock());
    }
}
