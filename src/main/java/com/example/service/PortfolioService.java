package com.example.service;

import com.example.entity.User;
import com.example.repository.PortfolioRepository;
import com.example.repository.StockRepository;
import com.example.repository.UserRepository;
import com.example.entity.Portfolio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {

    private static final Logger log = LoggerFactory.getLogger(PortfolioService.class);

    @Autowired
    private PortfolioRepository portfolioRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StockRepository stockRepository;

    @Transactional
    public Portfolio createPortfolio(final int userId, final int stockId, final int quantity) {
        log.info("Creating portfolio for user: {}, stock: {}, quantity: {}", userId, stockId, quantity);
        Portfolio portfolio = new Portfolio();
        portfolio.setUser(userRepository.getOne(userId));
        portfolio.setStock(stockRepository.getOne(stockId));
        portfolio.setQuantity(quantity);
        return portfolioRepository.saveAndFlush(portfolio);
    }

    @Transactional(readOnly = true)
    public Optional<Portfolio> findPortfolio(final int id) {
        log.info("Searching portfolio by id: {}", id);
        return portfolioRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Portfolio> getByUser(final User user) {
        log.info("Searching portfolio by user: {}", user.getId());
        return portfolioRepository.findByUser(user);
    }

    @Transactional(readOnly = true)
    public List<Portfolio> getByUserId(final int id) {
        log.info("Searching portfolio by userId: {}", id);
        Optional<User> user = userRepository.findById(id);
        return user.isPresent() ?
                portfolioRepository.findByUser(user.get()) :
                Collections.emptyList();
    }
}
