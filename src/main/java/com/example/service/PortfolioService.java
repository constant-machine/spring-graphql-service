package com.example.service;

import com.example.repository.PortfolioRepository;
import com.example.repository.StockRepository;
import com.example.repository.UserRepository;
import com.example.entity.Portfolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StockRepository stockRepository;

    @Transactional
    public Portfolio createPortfolio(final int userId, final int stockId, final int quantity) {
        Portfolio portfolio = new Portfolio();
        portfolio.setUser(userRepository.getOne(userId));
        portfolio.setStock(stockRepository.getOne(stockId));
        portfolio.setQuantity(quantity);
        return this.portfolioRepository.saveAndFlush(portfolio);
    }

    @Transactional(readOnly = true)
    public Optional<Portfolio> getPortfolio(final int id) {
        return this.portfolioRepository.findById(id);
    }
}
