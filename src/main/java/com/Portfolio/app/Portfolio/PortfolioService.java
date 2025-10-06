package com.Portfolio.app.Portfolio;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import com.Portfolio.app.Model.DashboardModel;
import com.Portfolio.app.Model.UserModel;
import com.Portfolio.app.Order.OrderDto;
import com.Portfolio.app.Repository.DashboardRepo;
import com.Portfolio.app.Repository.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final PortfolioRepository portfolioRepo;
    private final UserRepo userRepo;
    private final DashboardRepo dashboardRepo;


    // public PortfolioDto PortfolioUpdate(Long Id, String assetName, Double totalQuantity, Double avgBuyPrice) throws Exception{
    // public PortfolioDto PortfolioUpdate(Long Id, String assetName, OrderDto orderDto) throws Exception{
    public PortfolioDto PortfolioUpdate(Long Id,OrderDto orderDto) throws Exception{

        UserModel user = userRepo.findById(Id).orElseThrow(() -> new Exception("User Id Not Found"));
        // DashboardModel dashM = dashboardRepo.findById(Id).orElseThrow(() -> new Exception("Asset Id Not Found"));
        // DashboardModel dashM = dashboardRepo.findByAssetName(assetName).orElseThrow(() -> new Exception("Asset Not Found"));
        DashboardModel dashM = dashboardRepo.findByAssetName(orderDto.getAssetName()).orElseThrow(() -> new Exception("Asset Not Found"));

        PortfolioModel userExist = portfolioRepo.findByUserIdandAssetId(user.getId(), dashM.getId());

        double AssetQuantity = orderDto.getAssetQuantity();
        double AssetBuyPrice = dashM.getPrice();

        if (userExist == null) {
            
            PortfolioModel pm = new PortfolioModel();
            pm.setUser(user);
            pm.setDashboard(dashM);
            pm.setTotalQuantity(AssetQuantity);
            pm.setAvgBuyPrice(AssetBuyPrice);
            pm.setLastUpdated(OffsetDateTime.now());

            portfolioRepo.save(pm);

            PortfolioDto pdto = new PortfolioDto(pm.getPortfolioId(), pm.getTotalQuantity(), pm.getAvgBuyPrice());
            return pdto;
        }else{
            // To Update Existing Portfolio

            double TotalCost = userExist.getAvgBuyPrice() * userExist.getTotalQuantity();
            double Cost = AssetBuyPrice * AssetQuantity;
            double TotalAssetQuantity = userExist.getTotalQuantity() + AssetQuantity;

            double NewAvgPrice = (TotalCost + Cost) / TotalAssetQuantity;


            userExist.setTotalQuantity(TotalAssetQuantity);
            userExist.setAvgBuyPrice(NewAvgPrice);
            userExist.setLastUpdated(OffsetDateTime.now());

            portfolioRepo.save(userExist);

            return new PortfolioDto(userExist.getPortfolioId(), userExist.getTotalQuantity(), userExist.getAvgBuyPrice());
            
        }
    }
}
