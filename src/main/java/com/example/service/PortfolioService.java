package com.example.service;

import com.example.entity.User;
import com.example.repository.PortfolioRepository;
import com.example.repository.StockRepository;
import com.example.repository.UserRepository;
import com.example.entity.Portfolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
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
        return portfolioRepository.saveAndFlush(portfolio);
    }

    @Transactional(readOnly = true)
    public Optional<Portfolio> findPortfolio(final int id) {
        return portfolioRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Portfolio> getByUser(final User user) {
        return portfolioRepository.findByUser(user);
    }

    @Transactional(readOnly = true)
    public List<Portfolio> getByUserId(final int id) {
        Optional<User> user = userRepository.findById(id);
        return user.isPresent() ?
                portfolioRepository.findByUser(user.get()) :
                Collections.emptyList();
    }
}
