package com.Portfolio.app.Search;

import org.springframework.web.bind.annotation.RestController;

import com.Portfolio.app.Dto.DashboardDto;
import com.Portfolio.app.Exception.CustomException.AssetNotFoundException;
import com.Portfolio.app.Model.DashboardModel;
import com.Portfolio.app.Repository.DashboardRepo;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class SearchController {

    private final DashboardRepo Drepo;

    @GetMapping("/asset/{assetName}")
    public List<DashboardDto> SearchAsset(@PathVariable String assetName) throws Exception {

        Optional<DashboardModel> dm = Drepo.findByAssetName(assetName);

        if (dm.isPresent()) {
            
            List<DashboardDto> dashDto = dm.stream().map(x -> new DashboardDto(x.getId(), x.getAssetName(), x.getPrice())).toList();
    
            return dashDto;
        } else {
            throw new AssetNotFoundException("We Could not Found the Asset in our App :- " +assetName);
        }

    }
    
}
