package com.Portfolio.app.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String name;
    private String email;




    @ManyToMany
    @JoinTable(
    name = "UserDashboard",
    joinColumns = @JoinColumn(name = "Userid"),
    inverseJoinColumns = @JoinColumn(name = "DashboardId"))
    private List<DashboardModel> dashboard = new ArrayList<>();
    
}
