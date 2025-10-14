package com.Portfolio.app.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Portfolio.app.Model.DashboardModel;

@Repository
public interface DashboardRepo extends JpaRepository<DashboardModel, Long> {

    Optional<DashboardModel> findByAssetName(String assetName);

    // List<DashboardModel> SearchByKeywords();
}
