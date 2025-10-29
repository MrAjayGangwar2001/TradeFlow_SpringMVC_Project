package com.Portfolio.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebRolesConfig {
    
    @Bean
    public UserDetailsService UserAdminService(){

        UserDetails Users = User.withDefaultPasswordEncoder()
                            .username("user")
                            .password("user")
                            .roles("USER")
                            .build();

        UserDetails Admin = User.withDefaultPasswordEncoder()
                            .username("admin")
                            .password("admin")
                            .roles("ADMIN")
                            .build();

        return new InMemoryUserDetailsManager(Users, Admin);
    }
}
