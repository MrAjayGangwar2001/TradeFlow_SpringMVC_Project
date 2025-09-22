package com.Portfolio.app.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Portfolio.app.Dto.PortfolioDto;
import com.Portfolio.app.Model.PortfolioModel;
import com.Portfolio.app.Repository.PortfolioRepo;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepo prepo;


    public PortfolioDto PostPortfolioData(PortfolioDto portfolioDto){
        PortfolioModel pm = new PortfolioModel();

        pm.setAssetname(portfolioDto.getAssetname());
        pm.setPrice(portfolioDto.getPrice());
        pm.setQuantity(portfolioDto.getQuantity());
        pm.setUpdatedAt(null);

        prepo.save(pm);

        PortfolioDto pdto = new PortfolioDto(pm.getId(), pm.getAssetname(), pm.getPrice(), pm.getQuantity());
        return pdto;
    }

    public List<PortfolioDto> GetAllPortfolio(){

        List<PortfolioModel> pm = prepo.findAll();

        List<PortfolioDto> pd = pm.stream().map((x) -> new PortfolioDto(x.getId(), x.getAssetname(), x.getPrice(), x.getQuantity())).toList();

        return pd;
    }

    public PortfolioDto GetById(Long id) throws Exception{
        Optional<PortfolioModel> pm = prepo.findById(id);

        if (pm.isPresent()) {
            PortfolioModel pmdl = pm.get();

            PortfolioDto pdto = new PortfolioDto(pmdl.getId(), pmdl.getAssetname(), pmdl.getPrice(), pmdl.getQuantity());

            return pdto;
        }else{
            throw new Exception("We Could not found a Id : "+id);
        }
    }

    public PortfolioDto UpdateById(PortfolioDto portfolioDto, Long id) throws Exception{

        Optional<PortfolioModel> pm = prepo.findById(id);

        if (pm.isPresent()) {
            PortfolioModel pmd = pm.get();

            pmd.setAssetname(portfolioDto.getAssetname());
            pmd.setPrice(portfolioDto.getPrice());
            pmd.setQuantity(portfolioDto.getQuantity());

            prepo.save(pmd);

            PortfolioDto pfd = new PortfolioDto(pmd.getId(), pmd.getAssetname(), pmd.getPrice(), pmd.getQuantity());

            return pfd;
        } else {
            throw new Exception("Maaf Karna , Hume Database me id nhi mili ? ");
        }
    }


    public String DeleteById(Long id) throws Exception{
        Optional<PortfolioModel> pmdl = prepo.findById(id);

        if (pmdl.isPresent()) {
            PortfolioModel pmd = pmdl.get();

            prepo.delete(pmd);
            return "Your Given Id : "+id+ " Has Been Deleted from Database.";
        } else {
            throw new Exception("Id nhi mili ! Kripya Id Check Karein");
        }
    }

    //-----------------Special Method----------------

    public PortfolioDto getSpecialData(Long id) throws Exception{
        Optional<PortfolioModel> pm = prepo.findById(id);

        if (pm.isPresent()) {
            PortfolioModel pfm = pm.get();

            PortfolioDto pfd = new PortfolioDto(pfm.getId(), pfm.getAssetname(), pfm.getPrice(), pfm.getQuantity());

            return pfd;
        } else {
            throw new Exception("Hame Id Nhi Mili ? Dubara Sahi Id Se Try Karein !");
        }
    }


}
