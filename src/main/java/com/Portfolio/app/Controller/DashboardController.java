package com.Portfolio.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.Portfolio.app.Dto.DashboardDto;
import com.Portfolio.app.Service.DashboardService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
// @RequestMapping("/api/v1/Dashboard")
public class DashboardController {

    @Autowired
    private DashboardService ps;


    // @PostMapping()
    @PostMapping("/api/v1/Dashboard")
    public DashboardDto postDashboardData(@Valid @RequestBody DashboardDto dashboardDto) {
        
        return ps.PostDashboardData(dashboardDto);
    }

    // @GetMapping()
    @GetMapping("/api/v1/Dashboard")
    public List<DashboardDto> GetAllDashboard() {
        return ps.GetAllDashboard();
    }
    
    // @GetMapping("/{id}")
    @GetMapping("/api/v1/Dashboard/{id}")
    public DashboardDto getById(@PathVariable Long id) throws Exception {
        return ps.GetById(id);
    }
    

    // @PutMapping("/{id}")
    @PutMapping("/api/v1/Dashboard/{id}")
    public DashboardDto UpdateById(@PathVariable Long id, @RequestBody DashboardDto dashboardDto) throws Exception {

        return ps.UpdateById(dashboardDto, id);
    }


    // @DeleteMapping("/{id}")
    @DeleteMapping("/api/v1/Dashboard/{id}")
    public String DeleteById(@PathVariable Long id) throws Exception{
        return ps.DeleteById(id);
    }

    //-------------------------Special Method-----------------

    @GetMapping("/api/v1/users/{id}/Dashboard")
    public DashboardDto getSpecialData(@PathVariable Long id) throws Exception {
        return ps.getSpecialData(id);
    }
    
}
