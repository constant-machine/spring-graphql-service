package com.example.service;

import com.example.repository.StockRepository;
import com.example.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    @Transactional
    public Stock createStock(final String name, final String emitent, final Double price) {
        final Stock stock = new Stock();
        stock.setName(name);
        stock.setEmitent(emitent);
        stock.setPrice(price);
        return stockRepository.save(stock);
    }

    @Transactional(readOnly = true)
    public Optional<Stock> findById(final int id) {
        return stockRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Stock> find(final Stock stock) {
        return stockRepository.findById(stock.getId());
    }
}
