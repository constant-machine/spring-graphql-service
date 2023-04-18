package com.example.service.graphql.resolver;

import com.example.dao.entity.Portfolio;
import com.example.dao.entity.User;
import com.example.service.PortfolioService;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserResolver implements GraphQLResolver<User> {

    private final PortfolioService portfolioService;

    public List<Portfolio> portfolios(User user) {
        return portfolioService.getByUser(user);
    }
}
