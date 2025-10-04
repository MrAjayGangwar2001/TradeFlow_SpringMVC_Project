package com.Portfolio.app.Order;

import org.springframework.stereotype.Service;

import com.Portfolio.app.Dto.DashboardDto;
import com.Portfolio.app.Model.DashboardModel;
import com.Portfolio.app.Model.UserModel;
import com.Portfolio.app.Repository.UserRepo;
import com.Portfolio.app.Wallet.WalletModel;

import lombok.RequiredArgsConstructor;
/*
@Service
@RequiredArgsConstructor
public class orderServ {

    private final UserRepo Urepo;
    private final OrderRepository orepo;

    public String OrderPost(Long Id, OrderDto orderDto) throws Exception{
        UserModel um = Urepo.findById(Id).orElseThrow(() -> new Exception("User Id Not Found"));


        WalletModel wm =  um.getWallet();
        DashboardDto ddto = new DashboardDto();
         DashboardModel dm = new DashboardModel();
        Double TotalValue = orderDto.getAssetQuantity() * ddto.getPrice();

        if (TotalValue <= wm.getBalance()) {
            OrderModel om = new OrderModel();
            om.setAssetName(orderDto.getAssetName());
            om.setAssetQuantity(orderDto.getAssetQuantity());
            om.setOrderType(orderDto.getOrderType());
            om.setStatus(orderDto.getStatus());
            om.setWallet(wm);
            om.setDashboard(dm);
            orepo.save(om);

            return "Order has been Executed";
        } else {
            return "Wallet me paisa nhi hai";
        }
    }
}

*/