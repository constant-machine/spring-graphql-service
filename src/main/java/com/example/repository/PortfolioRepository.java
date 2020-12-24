package com.example.repository;

import com.example.entity.Portfolio;
import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Integer> {

    public List<Portfolio> findByUser(final User user);
}
