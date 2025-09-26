package com.Portfolio.app.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Portfolio.app.Model.DashboardModel;
import com.Portfolio.app.Model.UserModel;
import com.Portfolio.app.Repository.DashboardRepo;
import com.Portfolio.app.Repository.UserRepo;

@Service
public class UserDashboardService {
    
    @Autowired
    private DashboardRepo drepo;

    @Autowired
    private UserRepo uRepo;

    public String UserAsset(Long Userid, Long Assetid) throws Exception{
        Optional<UserModel> um = uRepo.findById(Userid);
        Optional<DashboardModel> dm = drepo.findById(Assetid);

        if (um.isPresent() && dm.isPresent()) {
            UserModel umd = um.get();
            DashboardModel dmd = dm.get();

            umd.getDashboard().add(dmd);
            dmd.getUsers().add(umd);

            uRepo.save(umd);

            return "Data Has been Saved in UserDashBoard";
        } else {
            throw new Exception("We can not find the UserId or AssetId");
        }
    }
}
