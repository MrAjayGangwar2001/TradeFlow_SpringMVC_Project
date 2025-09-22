package com.Portfolio.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Portfolio.app.Model.PortfolioModel;

@Repository
public interface PortfolioRepo extends JpaRepository<PortfolioModel, Long> {

}
