package com.example.service.graphql.query;

import com.example.model.StockDto;
import com.example.service.StockService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockQuery implements GraphQLQueryResolver {

    private final StockService stockService;

    public StockDto findStock(String stockName) {
        return stockService.findByName(stockName);
    }
}
