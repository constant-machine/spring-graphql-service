package com.example.service.graphql.mutation;

import com.example.model.StockDto;
import com.example.service.StockService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockMutation implements GraphQLMutationResolver {

    private final StockService stockService;

    public StockDto createStock(String name, String emitent, Double price) {
        return stockService.createStock(name, emitent, price);
    }
}
