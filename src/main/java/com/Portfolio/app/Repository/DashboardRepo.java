package com.Portfolio.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Portfolio.app.Model.DashboardModel;

@Repository
public interface DashboardRepo extends JpaRepository<DashboardModel, Long> {

}
