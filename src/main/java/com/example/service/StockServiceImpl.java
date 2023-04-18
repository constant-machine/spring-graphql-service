package com.example.service;

import com.example.dao.repository.StockRepository;
import com.example.dao.entity.Stock;
import com.example.model.StockDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final MapperFacade mapperFacade;
    private final StockRepository stockRepository;

    @Override
    @Transactional
    public StockDto createStock(String name, String emitent, double price) {
        log.info("Creating stock with name: {}, emitent: {}, price: {}", name, emitent, price);
        var stock = Stock.builder()
                .name(name)
                .emitent(emitent)
                .price(price)
                .build();
        stockRepository.save(stock);
        return mapperFacade.map(stock, StockDto.class);
    }

    @Override
    public StockDto findByName(String stockName) {
        log.info("Searching stock by name: {}", stockName);
        return mapperFacade.map(this.findStockByName(stockName), StockDto.class);
    }

    @Override
    public Stock findStockByName(String stockName) {
        log.info("Searching stock with name: {}", stockName);
        return stockRepository.findByName(stockName)
                .orElseThrow(() -> new RuntimeException(String.format("No stock found with such name: %s", stockName)));
    }
}
