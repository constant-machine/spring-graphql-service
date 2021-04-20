package com.example.service;

import com.example.repository.StockRepository;
import com.example.entity.Stock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StockService {

    private static final Logger log = LoggerFactory.getLogger(StockService.class);

    @Autowired
    private StockRepository stockRepository;

    @Transactional
    public Stock createStock(final String name, final String emitent, final Double price) {
        log.info("Creating stock with name: {}, emitent: {}, price: {}", name, emitent, price);
        final Stock stock = new Stock();
        stock.setName(name);
        stock.setEmitent(emitent);
        stock.setPrice(price);
        return stockRepository.save(stock);
    }

    @Transactional(readOnly = true)
    public Optional<Stock> findById(final int id) {
        log.info("Searching stock by id: {}", id);
        return stockRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Stock> find(final Stock stock) {
        log.info("Searching stock: {}", stock.getId());
        return stockRepository.findById(stock.getId());
    }
}
