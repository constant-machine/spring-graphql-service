package com.example.service;

import com.example.dao.entity.Stock;
import com.example.model.StockDto;

public interface StockService {
    StockDto createStock(String name, String emitent, double price);
    StockDto findByName(String stockName);
    Stock findStockByName(String stockName);
}
