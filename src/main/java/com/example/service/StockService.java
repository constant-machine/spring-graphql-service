package com.example.service;

import com.example.repository.StockRepository;
import com.example.entity.Stock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(final StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional
    public Stock createStock(final String name, final String emitent, final Double price) {
        final Stock stock = new Stock();
        stock.setName(name);
        stock.setEmitent(emitent);
        stock.setPrice(price);
        return this.stockRepository.save(stock);
    }

    @Transactional(readOnly = true)
    public Optional<Stock> getStock(final int id) {
        return this.stockRepository.findById(id);
    }
}
