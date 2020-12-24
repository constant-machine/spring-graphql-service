package com.example.graphql.mutation;

import com.example.entity.Stock;
import com.example.service.StockService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockMutation implements GraphQLMutationResolver {

    @Autowired
    private StockService stockService;

    public Stock createStock(final String name, final String emitent, final Double price) {
        return stockService.createStock(name, emitent, price);
    }
}
