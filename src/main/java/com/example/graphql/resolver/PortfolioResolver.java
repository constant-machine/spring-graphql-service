package com.example.graphql.resolver;

import com.example.entity.Portfolio;
import com.example.entity.Stock;
import com.example.entity.User;
import com.example.repository.StockRepository;
import com.example.repository.UserRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PortfolioResolver implements GraphQLResolver<Portfolio> {

    @Autowired
    UserRepository userRepository;

    @Autowired
    StockRepository stockRepository;

    public Optional<User> user(Portfolio portfolio) {
        return userRepository.findById(portfolio.getUser().getId());
    }

    public Optional<Stock> stock(Portfolio portfolio) {
        return stockRepository.findById(portfolio.getStock().getId());
    }
}
