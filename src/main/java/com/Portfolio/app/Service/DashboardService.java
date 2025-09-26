package com.Portfolio.app.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Portfolio.app.Dto.DashboardDto;
import com.Portfolio.app.Exception.CustomException.DashboardIdNotFoundException;
import com.Portfolio.app.Model.DashboardModel;
import com.Portfolio.app.Repository.DashboardRepo;

@Service
public class DashboardService {

    @Autowired
    private DashboardRepo prepo;

    public DashboardDto PostDashboardData(DashboardDto dashboardDto) {
        DashboardModel pm = new DashboardModel();

        pm.setAssetname(dashboardDto.getAssetname());
        // pm.setAssetname(null);     // It Throw Data_Integrity_Violation_Exception
        pm.setPrice(dashboardDto.getPrice());
        // pm.setQuantity(DashboardDto.getQuantity());
        // pm.setUpdatedAt(null);

        prepo.save(pm);

        // DashboardDto pdto = new DashboardDto(pm.getId(), pm.getAssetname(), pm.getPrice(), pm.getQuantity());
        DashboardDto pdto = new DashboardDto(pm.getId(), pm.getAssetname(), pm.getPrice());
        return pdto;
    }

    public List<DashboardDto> GetAllDashboard() {

        List<DashboardModel> pm = prepo.findAll();

        List<DashboardDto> pd = pm.stream()
                // .map((x) -> new DashboardDto(x.getId(), x.getAssetname(), x.getPrice(), x.getQuantity())).toList();
                .map((x) -> new DashboardDto(x.getId(), x.getAssetname(), x.getPrice())).toList();

        return pd;
    }

    public DashboardDto GetById(Long id) throws Exception {
        Optional<DashboardModel> pm = prepo.findById(id);

        if (pm.isPresent()) {
            DashboardModel pmdl = pm.get();

            // DashboardDto pdto = new DashboardDto(pmdl.getId(), pmdl.getAssetname(), pmdl.getPrice(),
            //         pmdl.getQuantity());
            DashboardDto pdto = new DashboardDto(pmdl.getId(), pmdl.getAssetname(), pmdl.getPrice());

            return pdto;
        } else {
            // throw new Exception("We Could not found a Id : "+id);
            throw new DashboardIdNotFoundException();

        }
    }

    public DashboardDto UpdateById(DashboardDto dashboardDto, Long id) throws Exception {

        Optional<DashboardModel> pm = prepo.findById(id);

        if (pm.isPresent()) {
            DashboardModel pmd = pm.get();

            pmd.setAssetname(dashboardDto.getAssetname());
            pmd.setPrice(dashboardDto.getPrice());
            // pmd.setQuantity(DashboardDto.getQuantity());

            prepo.save(pmd);

            // DashboardDto pfd = new DashboardDto(pmd.getId(), pmd.getAssetname(), pmd.getPrice(), pmd.getQuantity());
            DashboardDto pfd = new DashboardDto(pmd.getId(), pmd.getAssetname(), pmd.getPrice());

            return pfd;
        } else {
            // throw new Exception("Maaf Karna , Hume Database me id nhi mili ? ");
            throw new DashboardIdNotFoundException();

        }
    }

    public String DeleteById(Long id) throws Exception {
        Optional<DashboardModel> pmdl = prepo.findById(id);

        if (pmdl.isPresent()) {
            DashboardModel pmd = pmdl.get();

            prepo.delete(pmd);
            return "Your Given Id : " + id + " Has Been Deleted from Database.";
        } else {
            // throw new Exception("Id nhi mili ! Kripya Id Check Karein");
            throw new DashboardIdNotFoundException();

        }
    }

    // -----------------Special Method----------------

    public DashboardDto getSpecialData(Long id) throws Exception {
        Optional<DashboardModel> pm = prepo.findById(id);

        if (pm.isPresent()) {
            DashboardModel pfm = pm.get();

            // DashboardDto pfd = new DashboardDto(pfm.getId(), pfm.getAssetname(), pfm.getPrice(), pfm.getQuantity());
            DashboardDto pfd = new DashboardDto(pfm.getId(), pfm.getAssetname(), pfm.getPrice());

            return pfd;
        } else {
            // throw new Exception("Hame Id Nhi Mili ? Dubara Sahi Id Se Try Karein !");
            throw new DashboardIdNotFoundException();

        }
    }

}
