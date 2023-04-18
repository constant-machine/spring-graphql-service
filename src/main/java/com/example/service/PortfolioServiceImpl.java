package com.example.service;

import com.example.dao.entity.Stock;
import com.example.dao.entity.User;
import com.example.dao.repository.PortfolioRepository;
import com.example.dao.entity.Portfolio;
import com.example.model.PortfolioDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService {

    private final MapperFacade mapperFacade;
    private final UserService userService;
    private final StockService stockService;
    private final PortfolioRepository portfolioRepository;

    @Override
    @Transactional
    public PortfolioDto createPortfolio(String userName, String stockName, int quantity) {
        log.info("Creating portfolio for user: {}, stock: {}, quantity: {}", userName, stockName, quantity);
        User user = userService.findUserByName(userName);
        Stock stock = stockService.findStockByName(stockName);
        var portfolio = Portfolio.builder()
                .user(user)
                .stock(stock)
                .quantity(quantity)
                .build();
        portfolioRepository.save(portfolio);

        return mapperFacade.map(portfolio, PortfolioDto.class);
    }

    @Override
    public List<Portfolio> getByUser(final User user) {
        log.info("Searching portfolio by user: {}", user.getId());
        return portfolioRepository.findByUser(user);
    }

    @Override
    public List<PortfolioDto> getByUserName(String name) {
        log.info("Searching portfolio by userName: {}", name);
        User user = userService.findUserByName(name);
        return portfolioRepository.findByUser(user).stream()
                .map(e -> mapperFacade.map(e, PortfolioDto.class))
                .collect(Collectors.toList());
    }
}
