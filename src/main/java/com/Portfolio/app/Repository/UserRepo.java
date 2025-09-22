package com.Portfolio.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Portfolio.app.Model.UserModel;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Long> {

}
