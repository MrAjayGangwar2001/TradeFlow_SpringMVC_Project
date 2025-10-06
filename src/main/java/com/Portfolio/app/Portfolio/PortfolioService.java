package com.Portfolio.app.Portfolio;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.Portfolio.app.Model.DashboardModel;
import com.Portfolio.app.Model.UserModel;
import com.Portfolio.app.Repository.DashboardRepo;
import com.Portfolio.app.Repository.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final PortfolioRepository portfolioRepo;
    private final UserRepo userRepo;
    private final DashboardRepo dashboardRepo;


    public PortfolioDto PortfolioUpdate(Long Id, Long Id, Double totalQuantity, Double avgBuyPrice){

        UserModel user = userRepo.findById(Id).orElseThrow(() -> new Exception("User Id Not Found"));
        DashboardModel dashM = dashboardRepo.findById(Id).orElseThrow(() -> new Exception("Asset Id Not Found"));

        PortfolioModel userExist = portfolioRepo.findByUserIdandAssetId(Id, Id);

        if (userExist == null) {
            
            PortfolioModel pm = new PortfolioModel();
            pm.setUser(user);
            pm.setDashboard(dashM);
            pm.setTotalQuantity(totalQuantity);
            pm.setAvgBuyPrice(avgBuyPrice);
            pm.setLastUpdated(OffsetDateTime.now());

            portfolioRepo.save(pm);

            PortfolioDto pdto = new PortfolioDto(pm.getPortfolioId(), pm.getTotalQuantity(), pm.getAvgBuyPrice());
            return pdto;
        }else{
            // To Update Existing Portfolio

            double TotalCost = userExist.getAvgBuyPrice() * userExist.getTotalQuantity();
            double Cost = avgBuyPrice * totalQuantity;
            double TotalAssetQuentity = userExist.getTotalQuantity + totalQuantity
        }
    }
}
