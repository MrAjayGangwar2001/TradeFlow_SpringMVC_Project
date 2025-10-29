package com.Portfolio.app;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain SecurityConfiguration(HttpSecurity httpSecurity) throws Exception{

        httpSecurity
            .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/").permitAll()
                    // .requestMatchers("/user").authenticated()
                    // .requestMatchers("/admin").authenticated()
                    .requestMatchers("/user").hasRole("USER")
                    .requestMatchers("/admin").hasRole("ADMIN")
                    .anyRequest().authenticated()
                )
                .formLogin(form -> form
                .loginPage("/login")           // apna Login page
                .loginProcessingUrl("/login")  // form action URL
                .successHandler(new CustomSuccessHandler())
                // .defaultSuccessUrl("/user", true) // login success ke baad
                .failureUrl("/login?error=true")  // agar galat credentials
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll()
            );

        return httpSecurity.build();
    }

}
