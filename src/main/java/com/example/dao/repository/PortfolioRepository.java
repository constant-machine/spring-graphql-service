package com.example.dao.repository;

import com.example.dao.entity.Portfolio;
import com.example.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Integer> {

    List<Portfolio> findByUser(final User user);
}
