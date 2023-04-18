package com.example.service;

import com.example.dao.entity.Portfolio;
import com.example.dao.entity.User;
import com.example.model.PortfolioDto;

import java.util.List;

public interface PortfolioService {
    PortfolioDto createPortfolio(String userName, String stockName, int quantity);
    List<Portfolio> getByUser(final User user);
    List<PortfolioDto> getByUserName(String name);
}
