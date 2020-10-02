package com.example.dao;

import com.example.entity.Having;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository<Having, Integer> {
}
