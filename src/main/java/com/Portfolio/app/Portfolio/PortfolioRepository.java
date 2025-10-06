package com.Portfolio.app.Portfolio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository<PortfolioModel, Long>{

    PortfolioModel findByUserIdandAssetId(Long userId, Long assetId);

}
