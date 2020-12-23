package com.example.graphql.query;

import com.example.entity.Stock;
import com.example.service.StockService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StockQuery implements GraphQLQueryResolver {

    @Autowired
    private StockService stockService;

    public Optional<Stock> stockById(final int id) {
        return this.stockService.getStock(id);
    }
}
