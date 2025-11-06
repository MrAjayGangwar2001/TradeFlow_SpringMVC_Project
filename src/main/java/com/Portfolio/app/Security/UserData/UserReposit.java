package com.Portfolio.app.Security.UserData;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReposit extends JpaRepository<User, Long> {

    @Query("Select x from User x where x.email=:email")

    Optional<User> findByEmail(@Param("email") String email);

    User findByUsername(String userName);

}
