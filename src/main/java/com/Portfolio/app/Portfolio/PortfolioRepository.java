package com.Portfolio.app.Portfolio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository<PortfolioModel, Long>{

    PortfolioModel findByUser_IdAndDashboard_Id(Long userId, Long dashboardId);

    List<PortfolioModel> findByUser_Id(Long userId);

}
