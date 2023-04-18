package com.example.config;

import com.example.dao.entity.Portfolio;
import com.example.dao.entity.Stock;
import com.example.dao.entity.User;
import com.example.model.PortfolioDto;
import com.example.model.StockDto;
import com.example.model.UserDto;
import dev.akkinoc.spring.boot.orika.OrikaMapperFactoryConfigurer;
import ma.glasnost.orika.MapperFactory;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class MapperConfig implements OrikaMapperFactoryConfigurer {

    @Override
    public void configure(@NotNull MapperFactory orikaMapperFactory) {
        orikaMapperFactory.classMap(Stock.class, StockDto.class)
                .byDefault()
                .register();

        orikaMapperFactory.classMap(User.class, UserDto.class)
                .byDefault()
                .register();

        orikaMapperFactory.classMap(Portfolio.class, PortfolioDto.class)
                .byDefault()
                .register();
    }
}
