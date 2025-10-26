package com.Portfolio.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebConfig {

    @Bean
    public SecurityFilterChain SecurityConfig(HttpSecurity httpSecurity) throws Exception{

        httpSecurity
                .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/").permitAll()
                    .requestMatchers("/user", "/admin").authenticated()
                    // .requestMatchers("/admin").authenticated()
                )
                .formLogin(form -> form
                .loginPage("/login")           // apna page
                .loginProcessingUrl("/login")  // form action URL
                .defaultSuccessUrl("/user", true) // login success ke baad
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
