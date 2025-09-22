package com.Portfolio.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.Portfolio.app.Dto.PortfolioDto;
import com.Portfolio.app.Service.PortfolioService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
// @RequestMapping("/api/v1/portfolios")
public class PortfolioController {

    @Autowired
    private PortfolioService ps;


    // @PostMapping()
    @PostMapping("/api/v1/portfolios")
    public PortfolioDto postPortfolioData(@Valid @RequestBody PortfolioDto portfolioDto) {
        
        return ps.PostPortfolioData(portfolioDto);
    }

    // @GetMapping()
    @GetMapping("/api/v1/portfolios")
    public List<PortfolioDto> GetAllPortfolio() {
        return ps.GetAllPortfolio();
    }
    
    // @GetMapping("/{id}")
    @GetMapping("/api/v1/portfolios/{id}")
    public PortfolioDto getById(@PathVariable Long id) throws Exception {
        return ps.GetById(id);
    }
    

    // @PutMapping("/{id}")
    @PutMapping("/api/v1/portfolios/{id}")
    public PortfolioDto UpdateById(@PathVariable Long id, @RequestBody PortfolioDto portfolioDto) throws Exception {

        return ps.UpdateById(portfolioDto, id);
    }


    // @DeleteMapping("/{id}")
    @DeleteMapping("/api/v1/portfolios/{id}")
    public String DeleteById(@PathVariable Long id) throws Exception{
        return ps.DeleteById(id);
    }

    //-------------------------Special Method-----------------

    @GetMapping("/api/v1/users/{id}/portfolios")
    public PortfolioDto getSpecialData(@PathVariable Long id) throws Exception {
        return ps.getSpecialData(id);
    }
    
}
